package pl.sii.ums.services.converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface IGenericConverter<E,D> {

   E createFromDto(D dto);

   D createFromEntity(E entity);

   E updateEntity(E entity, D dto);

   default List<D> createDtoFromEntities(final Collection<E> entities) {
	   if(entities != null)
       return entities.stream()
               .map(this::createFromEntity)
               .collect(Collectors.toList());
	   else return null;
   }

   default List<E> createEntityFromDtos(final Collection<D> dtos) {
	   if(dtos != null)
       return dtos.stream()
               .map(this::createFromDto)
               .collect(Collectors.toList());
	   else return null;
   }
}