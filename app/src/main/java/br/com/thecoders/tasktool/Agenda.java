package br.com.thecoders.tasktool;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import br.com.thecoders.tasktool.Adapter.AdapterAgenda;
import br.com.thecoders.tasktool.Classes.Servico;
import br.com.thecoders.tasktool.Util.DeserializerData;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Agenda extends AppCompatActivity
{
    private SharedPref sharedPref;
    private List<Servico> servicos;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.data_button)
    public Button dataButton;
    @BindView(R.id.agenda_listview)
    public ListView agendaListView;

    private DateTime data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPref = new SharedPref(this);

        data = DateTime.now();
        dataButton.setText(String.format("%s\n%s", data.toString("EEEEEEEEEE"), data.toString("dd/MM/YYYY")));
        agendaListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent it = new Intent(Agenda.this, ServicoFuncionario.class);
                it.putExtra("Servico", servicos.get(i));
                startActivity(it);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        agendaDia();
    }

    public void selecionardata(View v)
    {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
            {
                data = new DateTime().withYear(i).withDayOfMonth(i1).withDayOfMonth(i2);
                dataButton.setText(String.format("%s\n%s", data.toString("EEEEEEEEEE"), data.toString("dd/MM/YYYY")));

                agendaDia();
            }
        }, data.getYear(), data.getMonthOfYear(), data.getDayOfMonth());
        dialog.show();
    }

    public void agendaDia()
    {
        JsonArray filters = new JsonArray();
        JsonArray items = new JsonArray();
        JsonObject itemDataInicio = new JsonObject();
        itemDataInicio.addProperty("name", "scheduledAt");
        itemDataInicio.addProperty("value", data.withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).toString("yyyy-MM-dd'T'HH:mm:ss"));
        itemDataInicio.addProperty("comparer", "GreaterThanOrEqual");
        JsonObject itemDataFim = new JsonObject();
        itemDataFim.addProperty("name", "scheduledAt");
        itemDataFim.addProperty("value", data.withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).toString("yyyy-MM-dd'T'HH:mm:ss"));
        itemDataFim.addProperty("comparer", "LessThanOrEqual");
        JsonObject itemId = new JsonObject();
        itemId.addProperty("name", "receiverId");
        itemId.addProperty("value", sharedPref.getId());

        items.add(itemDataInicio);
        items.add(itemDataFim);
        items.add(itemId);

        JsonObject filtros = new JsonObject();
        filtros.add("items", items);

        filters.add(filtros);

        JsonObject jsonObject = new JsonObject();
        jsonObject.add("filters", filters);
        jsonObject.addProperty("usePaginator", false);

        Ion.with(Agenda.this)
                .load(getResources().getString(R.string.url) + "task.all/")
                .setHeader("Authorization", sharedPref.getToken())
                .setJsonObjectBody(jsonObject)
                .asJsonObject()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>()
                {
                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> result)
                    {
                        if (result.getHeaders().code() == 200)
                        {
                            servicos = new GsonBuilder().registerTypeAdapter(DateTime.class, new DeserializerData()).create()
                                    .fromJson(result.getResult().get("items").getAsJsonArray(), new TypeToken<ArrayList<Servico>>()
                                    {
                                    }.getType());
                            agendaListView.setAdapter(new AdapterAgenda(Agenda.this, servicos));
                        }
                        else
                        {
                            Toast.makeText(Agenda.this, result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
