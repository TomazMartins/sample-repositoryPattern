package br.com.algorithmworks.samplerequery.model;


import android.os.Parcelable;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.ManyToOne;
import io.requery.Persistable;


@Entity
public interface IPhone extends Parcelable, Persistable {
    @Key @Generated
    int getId();

    String getNumber();

    @ManyToOne
    IPerson getPerson();
}
