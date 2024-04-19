package rest9.pkg1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IndianMoviesRepo extends JpaRepository<IndianMoviesEntity, Integer>{
	@Query(value="select * from indian_movies where year=:year",nativeQuery = true)
	public List<IndianMoviesEntity> findMoviesByYear(@Param("year") int year);
}
