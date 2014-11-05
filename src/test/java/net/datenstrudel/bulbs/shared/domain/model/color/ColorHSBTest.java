package net.datenstrudel.bulbs.shared.domain.model.color;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ColorHSBTest {

    @Test
    public void lLinearInterpolation() throws Exception {
        ColorHSB start = new ColorHSB(0f, 0f, 0f);
        ColorHSB end = new ColorHSB(200f, 360f, 100f);

        List<ColorHSB> res = (List) start.linearInterpolation(end, 360);

        assertThat(res.get(0), is(start));
        assertThat(res.size(),  is(361));
        assertThat(res.get(360).getHue(), is(360f));
        assertThat(res.get(360).getBrightness(), is(200f));
        assertThat(res.get(360).getSaturation(), is(100f));

        assertThat((double) res.get(180).getHue(), closeTo(180d, 0.001d));
        assertThat((double) res.get(180).getBrightness(), closeTo(100d, 0.001d));
        assertThat((double) res.get(180).getSaturation(), closeTo(50d, 0.001d));
    }
}