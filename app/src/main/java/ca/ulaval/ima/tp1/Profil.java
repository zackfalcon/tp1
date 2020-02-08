package ca.ulaval.ima.tp1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

public class Profil implements Parcelable {

    String firstName;
    String lastName;
    Calendar birthDate;
    String iDUL;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.lastName);
        dest.writeString(this.firstName);
        dest.writeSerializable(this.birthDate);
        dest.writeString(this.iDUL);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getiDUL() {
        return iDUL;
    }

    public void setiDUL(String iDUL) {
        this.iDUL = iDUL;
    }


    public Profil(String firstName, String lastName, Calendar birthDate, String iDUL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.iDUL = iDUL;
    }

    protected Profil(Parcel in) {
        this.lastName = in.readString();
        this.firstName = in.readString();
        this.birthDate = (Calendar) in.readSerializable();
        this.iDUL = in.readString();
    }

    public static final Parcelable.Creator<Profil> CREATOR = new Parcelable.Creator<Profil>() {
        @Override
        public Profil createFromParcel(Parcel source) {
            return new Profil(source);
        }

        @Override
        public Profil[] newArray(int size) {
            return new Profil[size];
        }
    };
}