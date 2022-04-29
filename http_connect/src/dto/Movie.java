package dto;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
class Genres {
	String Action;
	String Drama;
	String Thriller;
}

@RequiredArgsConstructor
@ToString
class Movies {
	
	int id;
	String url;
	String imdb_code;
	String title;
	String title_english;
	String title_long;
	String slug;
	int year;
	double rating;
	int runtime;
	private List<Genres> genres = new ArrayList<Genres>();
	String summary;
	String description_full;
	String synopsis;
	String yt_trailer_code;
	String language;
	String mpa_rating;
	String background_image;
	String background_image_original;
	String small_cover_image;
	String medium_cover_image;
	String large_cover_image;
	String state;
	
	public List<Genres> getGenres() {
		return genres;
	}
	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}
	
}

@RequiredArgsConstructor
@ToString
class Data {
	int movie_count;
	int limit;
	int page_number;
	private List<Movies> movies = new ArrayList<Movies>();
	
	public List<Movies> getMovies() {
		return movies;
	}
	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}
	
}

@RequiredArgsConstructor
@ToString
public class Movie {

	String status;
	String status_message;
	private List<Data> data = new ArrayList<Data>();
	
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	
}
