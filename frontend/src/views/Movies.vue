<template>
  <div class='movies'>
    <Movie />
  </div>
</template>

<script>
import Movie from '@/components/Movie.vue'

export default {
  name: 'Movies',
  components: {
    Movie
  }
}
</script>
