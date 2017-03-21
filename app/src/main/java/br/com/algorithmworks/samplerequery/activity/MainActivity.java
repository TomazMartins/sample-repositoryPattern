package br.com.algorithmworks.samplerequery.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import br.com.algorithmworks.samplerequery.R;
import br.com.algorithmworks.samplerequery.app.SampleApplication;
import br.com.algorithmworks.samplerequery.model.Person;
import br.com.algorithmworks.samplerequery.model.Phone;
import br.com.algorithmworks.samplerequery.record.PersonRecord;
import br.com.algorithmworks.samplerequery.record.PhoneRecord;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

public class MainActivity extends AppCompatActivity {
    private EntityDataStore<Persistable> dataStore;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        dataStore = ((SampleApplication) getApplication()).getDataStore();

        PersonRecord personRecord = new PersonRecord( dataStore );
        PhoneRecord phoneRecord = new PhoneRecord( dataStore );

        Person someone = new Person();
        someone.setName( "Example" );
        someone.setAge( 100 );

        personRecord.save( someone );

        Phone phoneSomeone = new Phone();
        phoneSomeone.setNumber( "99999-9999" );
        phoneSomeone.setPerson( someone );

        phoneRecord.save( phoneSomeone );

        Phone anotherPhoneSomeone = new Phone();
        anotherPhoneSomeone.setNumber( "88888-8888" );
        anotherPhoneSomeone.setPerson( someone );

        phoneRecord.save( anotherPhoneSomeone );

        Person anotherone = new Person();
        anotherone.setName( "Another Example" );
        anotherone.setAge( 50 );

        personRecord.save( anotherone );

        Phone phoneAnotherone = new Phone();
        phoneAnotherone.setNumber( "33333-3333" );
        phoneAnotherone.setPerson( anotherone );

        phoneRecord.save( phoneAnotherone );

        List<Person> people = personRecord.getAll();

        for( Person person : people ) {
            Log.i( "Record", "Person: {" +
                    "Id( " + person.getId() + " ); " +
                    "Name( " + person.getName() + " ); " +
                    "Qtd. Phones( " + person.getPhones().size() + " )" +
                    "}"
            );

            for( Phone phone : person.getPhones() ) {
                Log.i( "Record", "Phone: {" +
                        "Id( " + phone.getId() + " ); " +
                        "Number( " + phone.getNumber() + " ); " +
                        "Owner( " + phone.getPerson().getName() + " )" +
                        "}"
                );
            }
        }
    }
}
