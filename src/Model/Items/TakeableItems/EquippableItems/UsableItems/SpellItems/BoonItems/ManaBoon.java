package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.EffectShape;

public class ManaBoon extends BoonItem {

    public ManaBoon(int manaCost, int healthChange) {
        super(manaCost, healthChange, EffectShape.LINEAR, 1);
        setName("Mana Boon");
    }

    @Override
    public void useItem(CharacterEntity player, Skill skill) {
        if (hasEnoughMana(player)) {
            Effect triggerEffect = getEffectFactory().produceManaModifierEffect(calculateAppliedStatChange(player));

            player.effectEntities(getOwnLocation(player), triggerEffect);
            System.out.println("BoonItem used with enough mana");
        } else {
            System.out.println("BoonItem used, but not enough mana");
        }
    }

}