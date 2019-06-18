package com.example.oswald;

import android.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Monster {

    enum EN_SKILLS
    { COMBAT, SUBTERFUGE, MYSTICAL, TRICKERY }
    enum EN_STATS
    { HP, EN, SAVE }

    /// GENERATIVE STATS
    public int                          FD      ;// difficulty of the creature
    public int                          LVL     ;// toughness of the creature
    public HashMap<EN_STATS,Integer>       COUNTERS;// HP/Energy counter repartition
    public HashMap<EN_SKILLS,Integer>      SKILLS  ;// Skills with levels ( I , II, II, III )

    /// STATS
    public int                  health;
    public int                  energy;
    public int                  save;
    List<MonsterAttribute>      attributes;
    HashMap<EN_SKILLS, Integer>   skills;

    /// LORE
    public String   name;
    public String   description;


    public Monster( int iFD, int iLVL, HashMap<EN_STATS,Integer> iCounters, HashMap<EN_SKILLS,Integer> iSkills)
    {
        FD          = iFD;
        LVL         = iLVL;
        COUNTERS    = iCounters;
        SKILLS      = iSkills;
    }

    public void generate()
    {
        save    = FD + LVL + 10;
        health  = FD * LVL * COUNTERS.get(EN_STATS.HP);
        energy  = FD * LVL * COUNTERS.get(EN_STATS.EN);

        skills = new HashMap<>(4);
        Arrays.asList( EN_SKILLS.values() ).forEach( skill -> skills.put( skill, SKILLS.get(skill) ));

        attributes = new ArrayList<>( FD * 2 );
    }

}
