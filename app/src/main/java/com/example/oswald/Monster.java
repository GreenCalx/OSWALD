package com.example.oswald;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Monster {

    enum enumSKILLS
    { COMBAT, SUBTERFUGE, MYSTICAL, TRICKERY }
    enum enumSTATS
    { HP, EN, SAVE }

    /// GENERATIVE STATS
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
    public String   name;
    public String   description;


    public Monster(int iFD, int iLVL, HashMap<enumSTATS,Integer> iCounters, HashMap<enumSKILLS,Integer> iSkills)
    {
        FD          = iFD;
        LVL         = iLVL;
        COUNTERS    = iCounters;
        ORDERED_SKILLS      = iSkills;
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

}
