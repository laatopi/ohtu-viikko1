/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            players.add(new Player("Ollila", "HJK", 1000, 1000));
            players.add(new Player("Joel", "HJK", 0, 0));
            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void playerSearchToimii() {
        assertEquals(stats.search("Grandlund"), null);
        assertFalse(stats.search("Semenko").equals(null));
    }
    
    @Test
    public void teamSearchToimii() {
        assertFalse(stats.team("EDM").isEmpty());
        assertTrue(stats.team("Jokerit").isEmpty());
    }
    
    @Test
    public void topScoretToimii() {
        List<Player> lista = stats.topScorers(3);
        assertTrue(lista.get(0).getName().equals("Ollila"));
    }
    

}
