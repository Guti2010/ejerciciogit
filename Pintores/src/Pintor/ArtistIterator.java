package Pintor;

import java.util.Iterator;

public class ArtistIterator implements Iterator<Artist> {
    private final Artist[] artists;
    private int index = 0;

    public ArtistIterator(Artist[] artists) {
        this.artists = artists;
    }

    @Override
    public boolean hasNext() {
        return index < artists.length;
    }

    @Override
    public Artist next() {
        if (hasNext()) {
            return artists[index++];
        }
        throw new IllegalStateException("No more artists");
    }
}
