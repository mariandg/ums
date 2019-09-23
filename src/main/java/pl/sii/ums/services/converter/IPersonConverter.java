package pl.sii.ums.services.converter;

import pl.sii.ums.model.dto.PersonDto;
import pl.sii.ums.model.repository.entity.Person;

//Czy warto trzymać dodatkową warstwę pomiędzy Interfejsem generycznym a klasą implementującą interfejs
//według tego artykułu https://bulldogjob.pl/articles/287-converter-pattern-in-java-8
//warto. Rozumiem, że w przypadku niestandardowych funkcji (nie generycznych) można tu dodać metody,
//Ale dla obiektów bez skomplikowanych transformat czy dobrą praktyką jest robienie pustego interfejsu 
//pośredniczącego pomiędzy generykiem a klasą implementującą zestaw metod z interfejsu
public interface IPersonConverter extends IGenericConverter<Person, PersonDto> {

}
