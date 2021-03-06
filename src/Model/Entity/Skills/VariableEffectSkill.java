package Model.Entity.Skills;

public abstract class VariableEffectSkill extends Skill {

    VariableEffectSkill(String name) {
        super(name);
    }

    public int calculateChange(int change) {
        double percent = percentOfChangeToBeDealt();
        int healthChange = (int) (percent * change);
        return healthChange;
    }

    public int calculateDeviation(int correctValue) {
        double percent = percentOfChangeToBeDealt();
        int healthChange = (int) ((1-percent) * correctValue);
        return healthChange;
    }

    protected double percentOfChangeToBeDealt() {
        double percent = (double) ( getRandom().nextInt(101 - getSkillLevel()) + getSkillLevel() ) / 100;
        return percent;
    }

}
