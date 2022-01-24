<template>
  <div class="movie">
    <h1>List of movies</h1>
    <table class="table table-striped">
      <thead>
        <th>Movie name</th>
        <th>Description</th>
      </thead>
      <tbody>
        <tr v-for="movie in movies" v-bind:key="movie.id">
          <td>{{ movie.title }}</td>
          <td>{{ movie.shortDescription }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import MovieService from "../services/MoviesService";

export default {
  name: "Movie",

  data() {
    return {
      movies: [],
    };
  },
  methods: {
    getMovies() {
      MovieService.getMovies().then((response) => {
        this.movies = response.data;
      });
    },
  },
  created() {
    this.getMovies();
  },
};
</script>
