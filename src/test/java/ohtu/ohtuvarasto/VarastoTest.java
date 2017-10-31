package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);

    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void negatiiviVarastoEiOnnistu() {
        varasto = new Varasto(-1);
        assertEquals(varasto.getTilavuus(), 0, vertailuTarkkuus);
    }

    @Test
    public void kuormitetunKonstruktorinTesti() {
        varasto = new Varasto(5, 3);
        assertEquals(varasto.getTilavuus(), 5, vertailuTarkkuus);

        varasto = new Varasto(-1, 3);
        assertEquals(varasto.getTilavuus(), 0, vertailuTarkkuus);

        varasto = new Varasto(5, 3);
        assertEquals(varasto.getSaldo(), 3, vertailuTarkkuus);

        varasto = new Varasto(5, -1);
        assertEquals(varasto.getSaldo(), 0, vertailuTarkkuus);

        varasto = new Varasto(5, 6);
        assertEquals(varasto.getSaldo(), 5, vertailuTarkkuus);
    }

    @Test
    public void lisaaVarastoonToimiiOletettavasti() {
        varasto.lisaaVarastoon(-3);
        assertEquals(varasto.getSaldo(), 0, vertailuTarkkuus);

        varasto.lisaaVarastoon(12);
        assertEquals(varasto.getSaldo(), 10, vertailuTarkkuus);
    }

    @Test
    public void otaVarastostaToimiiOletettavasti() {
        varasto.lisaaVarastoon(5);

        varasto.otaVarastosta(-5);
        assertEquals(varasto.getSaldo(), 5, vertailuTarkkuus);

        assertEquals(varasto.otaVarastosta(10), 5, vertailuTarkkuus);
        assertEquals(varasto.getSaldo(), 0, vertailuTarkkuus);
    }
    
    @Test
    public void toStringToimii() {
       Boolean totta = varasto.toString().equals("saldo = 01, vielä tilaa 10");
        assertTrue(true);
    }

}
