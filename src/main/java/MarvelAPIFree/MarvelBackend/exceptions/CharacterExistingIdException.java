package MarvelAPIFree.MarvelBackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CharacterExistingIdException extends RuntimeException{

  public CharacterExistingIdException(String message){
    super(message);
  }
}