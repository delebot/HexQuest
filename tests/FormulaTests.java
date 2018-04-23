import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.HostileNPC;
import Model.Entity.Character.Player;
import Model.Entity.Character.PlayerFactory;
import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static Model.Zone.HexFormulas.distanceToPoint;

public class FormulaTests {

    @Test
    public void testDistanceFormula(){
        Point x1 = new Point(0,0);
        Point y1 = new Point(5,0);

        double z1 = distanceToPoint(x1,y1);
        System.out.println(z1);
        //Assert.assertTrue(z1 == 4);

        Point x2 = new Point(1,1);
        Point y2 = new Point(5,0);

        double z2 = distanceToPoint(x2,y2);
        System.out.println(z2);
        //Assert.assertTrue(z1 == 4);

        Point x3 = new Point(2,1);
        Point y3 = new Point(7,5);

        double z3 = distanceToPoint(x3,y3);
        System.out.println(z3);
        //Assert.assertTrue(z3 == 6);
    }

    @Test
    public void testTrails(){
        World world = new World();
        Zone zone = new Zone(0, 7, 7);
        Player characterSmash = PlayerFactory.produceSmasher();
        CharacterEntity npc = new HostileNPC(zone);

        world.addZone(zone);
        world.setPlayer(characterSmash);
        world.addHostileNPC(npc);
        characterSmash.setZone(zone);

        for(int i = 0; i < 7; ++i){
            for(int j = 0; j < 7; ++j)
                zone.add(new Point(i,j), Terrain.GRASS);
        }

        zone.addPlayer(new Point(0,1), characterSmash);
        zone.addPlayer(new Point(6,6), npc);

        System.out.println(zone.getCharacterLocation(characterSmash));
        System.out.println(zone.getCharacterLocation(npc));

        world.update();

        System.out.println(zone.getCharacterLocation(characterSmash));
        System.out.println(zone.getCharacterLocation(npc));

        world.update();

        System.out.println(zone.getCharacterLocation(characterSmash));
        System.out.println(zone.getCharacterLocation(npc));
        //System.out.println(world.calculateNPCtoPlayerTrail(zone, new Point(6,6)));

    }

    @Test
    public void testChasing(){
        World world = new World();
        Zone zone = new Zone(0, 7, 7);
        Player characterSmash = PlayerFactory.produceSmasher();
        CharacterEntity npc = new HostileNPC(zone);

        world.addZone(zone);
        world.setPlayer(characterSmash);
        world.addHostileNPC(npc);

        for(int i = 0; i < 7; ++i){
            for(int j = 0; j < 7; ++j)
                zone.add(new Point(i,j), Terrain.GRASS);
        }

        zone.addPlayer(new Point(1,1), characterSmash);
        zone.addPlayer(new Point(1,3), npc);

        System.out.println(zone.getCharacterLocation(characterSmash));
        System.out.println(zone.getCharacterLocation(npc));

        world.update();

        System.out.println(zone.getCharacterLocation(characterSmash));
        System.out.println(zone.getCharacterLocation(npc));

        world.update();
        world.update();
        world.update();

        System.out.println(zone.getCharacterLocation(characterSmash));
        System.out.println(zone.getCharacterLocation(npc));
        //System.out.println(world.calculateNPCtoPlayerTrail(zone, new Point(6,6)));

    }
}
