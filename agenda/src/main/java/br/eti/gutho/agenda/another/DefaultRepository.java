package br.eti.gutho.agenda.another;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface DefaultRepository<T, ID> extends PagingAndSortingRepository<T, ID> {

}
