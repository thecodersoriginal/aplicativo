package br.com.thecoders.tasktool;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Agenda extends AppCompatActivity
{
    @BindView(R.id.data_button)
    public Button dataButton;
    @BindView(R.id.agenda_listview)
    public ListView agenda;

    private DateTime data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        ButterKnife.bind(this);

        data = DateTime.now();
        dataButton.setText(String.format("%s\n%s", data.toString("EEEEEEEEEE"), data.toString("dd/MM/YYYY")));

        agenda.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                startActivity(new Intent(Agenda.this, Servico.class));
            }
        });
    }

    public void selecionardata(View v)
    {
        startActivity(new Intent(Agenda.this, Servico.class));

        /*DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
            {
                data = new DateTime().withYear(i).withDayOfMonth(i1).withDayOfMonth(i2);
                dataButton.setText(String.format("%s\n%s", data.toString("EEEEEEEEEE"), data.toString("dd/MM/YYYY")));
            }
        }, data.getYear(), data.getMonthOfYear(), data.getDayOfMonth());
        dialog.show();*/
    }
}
