package com.example.oswald;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Monster implements Parcelable {


    // -------------------------------------------------------------------
    /// PARCELABLE
    // -------------------------------------------------------------------
    //  INT[]
    //  0   FD          INT
    //  1   NIV         INT
    //  2   SKILLS      INT[]
    //      2           COMBAT      INT
    //      3           MYSTICAL    INT
    //      4           SUBTERFUGE  INT
    //      5           TRICKERY    INT
    //  6   COUNTERS    INT[]
    //      6           HP          INT
    //      7           ENERGY      INT
    //
    //  STRING[]
    //  0   STRING      MONSTER_NAME
    //  1   STRING      DESCRIPTION
    // -------------------------------------------------------------------
    protected Monster(Parcel in) {

        /// INT GENERATIVE DATAS
        int[] int_datas = new int[N_GENERATIVE_STATS];
        in.readIntArray(int_datas);

        int fd = int_datas[0];
        int niv = int_datas[1];

        int combat_rank = int_datas[2];
        int mystical_rank = int_datas[3];
        int subterfuge_rank = int_datas[4];
        int trickery_rank = int_datas[5];
        HashMap<enumSKILLS,Integer> skills = new HashMap<>(4);
        skills.put(enumSKILLS.COMBAT, combat_rank);
        skills.put(enumSKILLS.MYSTICAL, mystical_rank);
        skills.put(enumSKILLS.SUBTERFUGE, subterfuge_rank);
        skills.put(enumSKILLS.TRICKERY, trickery_rank);

        int hp_cpt = int_datas[6];
        int energy_cpt = int_datas[7];
        HashMap<enumSTATS,Integer> stats = new HashMap<>(2);
        stats.put(enumSTATS.HP, hp_cpt);
        stats.put(enumSTATS.EN, energy_cpt);

        FD                  = fd;
        LVL                 = niv;
        COUNTERS            = stats;
        ORDERED_SKILLS      = skills;

        generate();

        /// STRING DESCRIPTIVE DATAS
        String[] str_datas = new String[N_LORE_ATTR];
        in.readStringArray(str_datas);

        this.name = str_datas[0];
        this.description = str_datas[1];

    }

    public static final Creator<Monster> CREATOR = new Creator<Monster>() {
        @Override
        public Monster createFromParcel(Parcel in) {
            return new Monster(in);
        }

        @Override
        public Monster[] newArray(int size) {
            return new Monster[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        int[] int_datas = new int[N_GENERATIVE_STATS];
        int_datas[0] = FD;
        int_datas[1] = LVL;
        int_datas[2] = skills.get(enumSKILLS.COMBAT);
        int_datas[3] = skills.get(enumSKILLS.MYSTICAL);
        int_datas[4] = skills.get(enumSKILLS.SUBTERFUGE);
        int_datas[4] = skills.get(enumSKILLS.TRICKERY);
        int_datas[5] = COUNTERS.get(enumSTATS.HP);
        int_datas[6] = COUNTERS.get(enumSTATS.EN);
        parcel.writeIntArray(int_datas);

        String[] str_datas = new String[N_LORE_ATTR];
        str_datas[0] = name;
        str_datas[1] = description;
        parcel.writeStringArray(str_datas);

    }

    // -------------------------------------------------------------------
    /// MONSTER
    // -------------------------------------------------------------------
    enum enumSKILLS
    { COMBAT, SUBTERFUGE, MYSTICAL, TRICKERY }
    enum enumSTATS
    { HP, EN, SAVE }

    /// GENERATIVE STATS
    public final int                    N_GENERATIVE_STATS = 8;
    public int                          FD      ;// difficulty of the creature
    public int                          LVL     ;// toughness of the creature
    public HashMap<enumSTATS,Integer>   COUNTERS;// HP/Energy counter repartition
    public HashMap<enumSKILLS,Integer>  ORDERED_SKILLS  ;// Skills with levels ( I , II, II, III )

    /// STATS
    public int                      health;
    public int                      energy;
    public int                      save;
    List<MonsterAttribute>          attributes;
    HashMap<enumSKILLS, Integer>    skills;

    /// LORE
    public final int N_LORE_ATTR = 2;
    public String   name            ="";
    public String   description     ="";
    public String   type            ="";


    public Monster(int iFD, int iLVL, HashMap<enumSTATS,Integer> iCounters, HashMap<enumSKILLS,Integer> iSkills)
    {
        FD                  = iFD;
        LVL                 = iLVL;
        COUNTERS            = iCounters;
        ORDERED_SKILLS      = iSkills;

        generate();
    }

    public void generate()
    {
        save    = FD + LVL + 10;
        health  = FD * LVL * COUNTERS.get(enumSTATS.HP);
        energy  = FD * LVL * COUNTERS.get(enumSTATS.EN);

        skills = new HashMap<>(4);
        Arrays.asList( enumSKILLS.values() ).forEach(skill -> skills.put( skill, ORDERED_SKILLS.get(skill) ));

        attributes = new ArrayList<>( FD * 2 );
    }

    @Override
    public String toString() {
        return this.name +"  <"+ this.type+">";
    }

}
