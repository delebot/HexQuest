package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.EnchantmentItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.EffectShape;
import Model.Enums.SkillType;

public class DecreaseObservationEnchantment extends EnchantmentItem {

    public DecreaseObservationEnchantment(int manaCost, int skillDecrease, EffectShape effectShape, int range) {
        super(manaCost, skillDecrease, effectShape, range);
        setName("Observation Enchantment");
    }

    @Override
    public void useItem(CharacterEntity player, Skill skill) {
        if (hasEnoughMana(player)) {
            Effect triggerEffect = getEffectFactory().produceSkillModifierEffect(-calculateAppliedStatChange(player), SkillType.OBSERVATIONSKILL);

            player.effectEntities(getEffectedCoordinates(player), triggerEffect);
            System.out.println("EnchantmentItem used with enough mana");
        } else {
            System.out.println("EnchantmentItem used, but not enough mana");
        }
    }

}
