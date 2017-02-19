package mikecandco.de;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by mikehuff on 2/19/17.
 */
public class BracketValidator {

  public static void main(String[] args) {
  }

  public boolean isValid(String code) {

    Map<Character, Character> openersToClosers = new HashMap<Character, Character>();
    openersToClosers.put('(', ')');
    openersToClosers.put('[', ']');
    openersToClosers.put('{', '}');

    Set<Character> openers = openersToClosers.keySet();
    Set<Character> closers = new HashSet<Character>(openersToClosers.values());

    Stack<Character> openersStack = new Stack<Character>();

    for (char c : code.toCharArray()) {
      if (openers.contains(c)) {
        openersStack.push(c);
      } else if (closers.contains(c)) {
        if (openersStack.empty()) {
          return false;
        } else {
          char lastUnclosedOpener = openersStack.pop();
          if (openersToClosers.get(lastUnclosedOpener) != c) {
            return false;
          }
        }
      }
    }
    return openersStack.empty();
  }

}
