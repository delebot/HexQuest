package Model.Items;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;

public abstract class Item {
    Effect effect;
    private String name;

    public boolean trigger(CharacterEntity entity) {
        effect.trigger(entity);
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
