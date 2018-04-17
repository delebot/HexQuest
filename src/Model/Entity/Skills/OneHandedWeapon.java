package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.ONEHANDED;

public class OneHandedWeapon extends Skill {

    public OneHandedWeapon() {}

    @Override
    public void effect(CharacterEntity player) {
        player.useItemSlot(ONEHANDED);
    }
}
