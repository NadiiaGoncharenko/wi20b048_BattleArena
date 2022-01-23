package Items.OldVersion.Adapter_LongBow;

import Items.IEquipment;
import Items.OldVersion.LongBow;
import Pawn.Hero;

public class LongBobAdapter implements IEquipment {

    private LongBow longBow;

    public LongBobAdapter(LongBow longBow) {
        this.longBow = longBow;
    }

    @Override
    public void use(Hero other) {
        int strengt = longBow.hit();

        other.reduceHealth(strengt);
    }
}
