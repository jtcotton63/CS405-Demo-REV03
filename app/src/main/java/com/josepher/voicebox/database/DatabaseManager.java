package com.josepher.voicebox.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dao.LocalityTable;
import com.josepher.voicebox.database.dao.UniversityTable;
import com.josepher.voicebox.database.dao.UserTable;
import com.josepher.voicebox.database.dto.DTO_Locality;
import com.josepher.voicebox.database.dto.DTO_University;
import com.josepher.voicebox.database.dto.DTO_User;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Josepher on 3/7/2016.
 */
public class DatabaseManager {

    private static DBHelper dbHelper;
    private static SQLiteDatabase db;

    private static void initialize(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);
    }

    public static SQLiteDatabase getDB(Context context) {
        // Create the db
        if(db == null) {
            initialize(context);
        }

        return db;
    }

    public static void insertDummyData() {
        // THINGS TO FIX:
        // Jurisdiction of local leaders isn't stored as name "Provo City Councilman"
        // Proposals - localityId / universtiyId - in the insert

        // Localities
        DTO_Locality provo = new DTO_Locality("City of Provo", "Provo", "Utah", "Utah");
        LocalityTable.insert(db, provo);
        DTO_Locality orem = new DTO_Locality("City of Orem", "Orem", "Utah", "Utah");
        LocalityTable.insert(db, orem);
        DTO_Locality americanFork = new DTO_Locality("City of American Fork", "American Fork", "Utah", "Utah");
        LocalityTable.insert(db, americanFork);
        DTO_Locality utahCounty = new DTO_Locality("Utah County", null, "Utah", "Utah");
        LocalityTable.insert(db, utahCounty);
        DTO_Locality utah = new DTO_Locality("State of Utah", null, null, "Utah");
        LocalityTable.insert(db, utah);
        DTO_Locality glenrock = new DTO_Locality("City of Glenrock", "Glenrock", "Converse", "Wyoming");
        LocalityTable.insert(db, glenrock);
        DTO_Locality converseCounty = new DTO_Locality("Converse County", null, "Converse", "Wyoming");
        LocalityTable.insert(db, converseCounty);
        DTO_Locality wyoming = new DTO_Locality("State of Wyoming", null, null, "Wyoming");
        LocalityTable.insert(db, wyoming);
        DTO_Locality unitedStates = new DTO_Locality("United States", null, null, null);
        LocalityTable.insert(db, unitedStates);

        int localityRows = db.rawQuery("select * from " + LocalityTable.LOCALITY_TABLE_NAME, null).getCount();
        if(localityRows != 9)
            throw new RuntimeException("Localities not inserted correctly");

        // Brigham Young University
        DTO_University byu = new DTO_University("Brigham Young University");
        // Adjust BYU
        byu.officialId = 14;
        byu.localityId = 1;
        UniversityTable.insert(db, byu);

        int universityRows = db.rawQuery("select * from " + UniversityTable.UNIVERSITY_TABLE_NAME, null).getCount();
        if(universityRows != 1)
            throw new RuntimeException("Universities not inserted correctly");

        // Find the locality id for each of the localities
        provo = getLocalityId(provo);
        orem = getLocalityId(orem);
        americanFork = getLocalityId(americanFork);
        utahCounty = getLocalityId(utahCounty);
        utah = getLocalityId(utah);
        glenrock = getLocalityId(glenrock);
        converseCounty = getLocalityId(converseCounty);
        wyoming = getLocalityId(wyoming);
        unitedStates = getLocalityId(unitedStates);

        // People
        DTO_User paige = new DTO_User("paige", "paige", new Timestamp((new Date()).getTime()), "Egaipe", "Paige");
        UserTable.insert(db, paige, provo, null);
        DTO_User pat = new DTO_User("pat", "pat", new Timestamp((new Date()).getTime()), "Tap", "Pat");
        UserTable.insert(db, pat, provo, null);
        DTO_User oscar = new DTO_User("oscar", "oscar", new Timestamp((new Date()).getTime()), "Racso", "Oscar");
        UserTable.insert(db, oscar, orem, null);
        DTO_User aaron = new DTO_User("aaron", "aaron", new Timestamp((new Date()).getTime()), "Noraa", "Aaron");
        UserTable.insert(db, aaron, americanFork, null);
        DTO_User weston = new DTO_User("weston", "weston", new Timestamp((new Date()).getTime()), "Nostew", "Weston");
        UserTable.insert(db, weston, glenrock, null);
        DTO_User braden = new DTO_User("braden", "braden", new Timestamp((new Date()).getTime()), "Nedarb", "Braden");
        UserTable.insert(db, braden, provo, byu);

        int peopleRows = db.rawQuery("select * from " + UserTable.USER_TABLE_NAME, null).getCount();
        if(peopleRows != 6)
            throw new RuntimeException("Universities not inserted correctly");

        // Elected officials
        DTO_User peterProvoCityCouncilman = new DTO_User("peter", "peter", new Timestamp((new Date()).getTime()), "Retep", "Peter");
        UserTable.insert(db, peterProvoCityCouncilman, provo, null);
        DTO_User oakleyOremCityCouncilman = new DTO_User("oakley", "oakley", new Timestamp((new Date()).getTime()), "Yelkao", "Oakley");
        UserTable.insert(db, oakleyOremCityCouncilman, orem, null);
        DTO_User ulyssesUtahCountyCommisioner = new DTO_User("ulysses", "ulysses", new Timestamp((new Date()).getTime()), "Sessylu", "Ulysses");
        UserTable.insert(db, ulyssesUtahCountyCommisioner, americanFork, null);
        DTO_User uzziahUtah = new DTO_User("uzziah", "uzziah", new Timestamp((new Date()).getTime()), "Haizzu", "Uzziah");
        UserTable.insert(db, uzziahUtah, orem, null);
        DTO_User winstonConverseCountyCommisioner = new DTO_User("winston", "winston", new Timestamp((new Date()).getTime()), "Notsniw", "Winston");
        UserTable.insert(db, winstonConverseCountyCommisioner, glenrock, null);
        DTO_User wesleyWyoming = new DTO_User("wesley", "wesley", new Timestamp((new Date()).getTime()), "Yelsew", "Wesley");
        UserTable.insert(db, wesleyWyoming, glenrock, null);
        DTO_User fredFederal = new DTO_User("fred", "fred", new Timestamp((new Date()).getTime()), "Derf", "Fred");
        UserTable.insert(db, fredFederal, americanFork, null);
        DTO_User brighamPresident = new DTO_User("brigham", "brigham", new Timestamp((new Date()).getTime()), "Mahgirb", "Brigham");
        UserTable.insert(db, brighamPresident, orem, byu);

        peopleRows = db.rawQuery("select * from " + UserTable.USER_TABLE_NAME, null).getCount();
        if(peopleRows != 14)
            throw new RuntimeException("Universities not inserted correctly");

        // Set the officialId for the localities
        provo = extractOfficialForLocality(db, provo, peterProvoCityCouncilman);
        orem = extractOfficialForLocality(db, orem, oakleyOremCityCouncilman);
        utahCounty = extractOfficialForLocality(db, utahCounty, ulyssesUtahCountyCommisioner);
        utah = extractOfficialForLocality(db, utah, uzziahUtah);
        converseCounty = extractOfficialForLocality(db, converseCounty, winstonConverseCountyCommisioner);
        wyoming = extractOfficialForLocality(db, wyoming, wesleyWyoming);
        unitedStates = extractOfficialForLocality(db, unitedStates, fredFederal);

        // Do all these through the daos

        // Propositions

        // In favors

        // Not in favors
    }

    private static DTO_Locality getLocalityId(DTO_Locality locality) {
        Cursor id = db.rawQuery("select " + LocalityTable.ID + " from " + LocalityTable.LOCALITY_TABLE_NAME + " where " + LocalityTable.NAME + "='" + locality.name + "'", null);
        id.moveToFirst();
        locality.id = id.getInt(0);
        return locality;
    }

    private static DTO_Locality extractOfficialForLocality(SQLiteDatabase db, DTO_Locality locality, DTO_User localOfficial) {
        Cursor officialId = db.rawQuery("select " + UserTable.ID + " from " + UserTable.USER_TABLE_NAME + " where " + UserTable.FIRST_NAME + "='" + localOfficial.firstName + "'", null);
        officialId.moveToFirst();
        locality.officialId = officialId.getInt(0);
        boolean successful = LocalityTable.update(db, locality);
        if(!successful)
            throw new RuntimeException("Not able to update locality officialId");
        return locality;
    }
}
