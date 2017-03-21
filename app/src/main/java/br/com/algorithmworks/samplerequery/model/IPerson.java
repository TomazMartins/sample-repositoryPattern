package br.com.algorithmworks.samplerequery.model;

import android.os.Parcelable;

import java.util.List;

import io.requery.Entity;
import io.requery.Generated;
import io.requery.Key;
import io.requery.OneToMany;
import io.requery.Persistable;

@Entity
public interface IPerson extends Parcelable, Persistable {
    @Key @Generated
    int getId();

    String getName();
    int getAge();

    @OneToMany
    List<Phone> getPhones();
}
