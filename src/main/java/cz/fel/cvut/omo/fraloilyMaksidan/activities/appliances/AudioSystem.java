package cz.fel.cvut.omo.fraloilyMaksidan.activities.appliances;

import cz.fel.cvut.omo.fraloilyMaksidan.enums.Durability;

public class AudioSystem extends ApplianceActivity {

    public AudioSystem() {
        super("Audio system", 4, Durability.NORMAL,
                10, 0, 0,
                1, 0, 0);
    }
}
