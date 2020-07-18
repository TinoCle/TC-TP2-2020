package app;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class App {
    public static void main(String[] args) throws Exception {

        // create a CharStream that reads from file
        CharStream input = CharStreams.fromFileName("src/app/input.txt");

        // create a lexer that feeds off of input CharStream
        alLexer lexer = new alLexer(input);
        
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // create a parser that feeds off the tokens buffer
        alParser parser = new alParser(tokens);
        
        Listener listener = new Listener(parser);

        parser.addParseListener(listener);
        // Solicito al parser que comience indicando una regla gramatical
        // En este caso la regla es el simbolo inicial
        ParseTree tree = parser.prog();

        // Implementacion de Visitor
        Visitor visitor = new Visitor();
        visitor.visit(tree);
        visitor.printCode();
    }
}