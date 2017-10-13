package com.vilen.learn.chapter5;

import com.vilen.learn.chapter1.Album;
import com.vilen.learn.chapter1.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vilen on 2017/10/13.
 * Map 缓存一个
 * 经典的例子就是实现一个缓存。
 * 传统的处理方式是先试着从Map 中取值，如果没有取到，创建一个新值并返回。
 */
public class Niceties {
    abstract class ArtistService {
        protected Map<String, Artist> artistCache = new HashMap<>();

        public abstract Artist getArtist(String name);

        protected Artist readArtistFromDb(String name) {
            return new Artist(name, "UK");
        }
    }

    class OldArtistService extends ArtistService {
        @Override
        public Artist getArtist(String name) {
            Artist artist = artistCache.get(name);
            if (artist == null) {
                artist = readArtistFromDb(name);
                artistCache.put(name, artist);
            }
            return artist;
        }
    }

    class Java8ArtistService extends ArtistService {
        @Override
        public Artist getArtist(String name) {
            return artistCache.computeIfAbsent(name, this::readArtistFromDb);
        }
    }

    //统计每个艺术家专辑的数量
    class ImperativeCount{
        public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> artistsByArtist) {
            Map<Artist, Integer> countOfAlbums = new HashMap<>();
            for (Map.Entry<Artist, List<Album>> entry : artistsByArtist.entrySet()) {
                Artist artist = entry.getKey();
                List<Album> albums = entry.getValue();
                countOfAlbums.put(artist, albums.size());
            }
            return countOfAlbums;
        }
    }

    class Java8Count {
        public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {
            Map<Artist, Integer> countOfAlbums = new HashMap<>();
            albumsByArtist.forEach(((artist, albumList) -> {
                countOfAlbums.put(artist, albumList.size());
            }));
            return countOfAlbums;
        }
    }
}
