package app;

import org.antlr.v4.runtime.*;

import app.Auxiliars.ErrorReporter;

public class ErrorListener extends BaseErrorListener{
    public static final ErrorListener INSTANCE = new ErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)
    {
        String sourceName = recognizer.getInputStream().getSourceName();
        if (!sourceName.isEmpty()) {
            sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
        }
        //ErrorReporter error = new ErrorReporter();
        //error.missingSemicolon(line);
        System.err.println(sourceName+"line "+line+":"+charPositionInLine+" "+msg);

    }
}