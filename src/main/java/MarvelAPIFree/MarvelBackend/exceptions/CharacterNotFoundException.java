package MarvelAPIFree.MarvelBackend.exceptions;

   public class CharacterNotFoundException extends RuntimeException {
        public CharacterNotFoundException(String message) {
            super(message);
        }
    }

