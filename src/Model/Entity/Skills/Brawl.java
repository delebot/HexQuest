package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.BRAWL;

public class Brawl extends Skill {

    public Brawl() {}

    @Override
    public void effect(CharacterEntity player) {
        player.useItemSlot(BRAWL);
    }
}
