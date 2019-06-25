package com.example.oswald;

import java.util.HashMap;

public class BestiaryUtils {

    public static HashMap<Monster.enumSKILLS,Integer> generateSkills(int iCombatRank, int iMysticalRank, int iSubterfugeRank, int iTrickeryRank)
    {
        HashMap<Monster.enumSKILLS,Integer> ret = new HashMap<>(4);
        ret.put(Monster.enumSKILLS.COMBAT, iCombatRank);
        ret.put(Monster.enumSKILLS.MYSTICAL, iMysticalRank);
        ret.put(Monster.enumSKILLS.SUBTERFUGE, iSubterfugeRank);
        ret.put(Monster.enumSKILLS.TRICKERY, iTrickeryRank);

        return ret;
    }

    public static HashMap<Monster.enumSTATS,Integer> generateCounters(int iHP, int iEnergy)
    {
        HashMap<Monster.enumSTATS,Integer> ret = new HashMap<>(4);
        ret.put(Monster.enumSTATS.HP, iHP);
        ret.put(Monster.enumSTATS.EN, iEnergy);

        return ret;
    }
}
