package br.com.algorithmworks.samplerequery.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import br.com.algorithmworks.samplerequery.R;
import br.com.algorithmworks.samplerequery.application.SampleApplication;
import br.com.algorithmworks.samplerequery.model.Person;
import br.com.algorithmworks.samplerequery.model.Phone;
import br.com.algorithmworks.samplerequery.record.PersonRecorder;
import br.com.algorithmworks.samplerequery.record.PhoneRecorder;
import br.com.algorithmworks.samplerequery.record.Recorder;
import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        EntityDataStore<Persistable> dataStore = ((SampleApplication) getApplication())
                .getDataStore();

        Recorder recorder = new PersonRecorder( dataStore );

        Person someone = new Person();
        someone.setName( "Example" );
        someone.setAge( 100 );

        recorder.save( someone );

        Person anotherone = new Person();
        anotherone.setName( "Another Example" );
        anotherone.setAge( 50 );

        recorder.save( anotherone );

        List<Person> people = (List<Person>) recorder.getAll();

        recorder = new PhoneRecorder( dataStore );

        Phone phoneSomeone = new Phone();
        phoneSomeone.setNumber( "99999-9999" );
        phoneSomeone.setPerson( someone );

        recorder.save( phoneSomeone );

        Phone anotherPhoneSomeone = new Phone();
        anotherPhoneSomeone.setNumber( "88888-8888" );
        anotherPhoneSomeone.setPerson( someone );

        recorder.save( anotherPhoneSomeone );

        Phone phoneAnotherone = new Phone();
        phoneAnotherone.setNumber( "33333-3333" );
        phoneAnotherone.setPerson( anotherone );

        recorder.save( phoneAnotherone );

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
