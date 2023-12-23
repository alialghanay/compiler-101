import java.io.File;
public class SoftwareBuilderMethod {

    public SoftwareBuilderMethod(String filePath) {
        String currentPath = System.getProperty("user.dir");
        File originalcode = new File(filePath);
        File CommentRemovercode = new File( currentPath + "\\CommentRemovercode");
        File tokencode = new File(currentPath + "\\tokencode");
        File Symboltablecode = new File(currentPath + "\\SymbolTablecode");
        GetRidOfComments.removeCommentsAndSpaces(originalcode, CommentRemovercode);
        CodeTokenizer.CodeTokenizer(CommentRemovercode, tokencode);
    }
}
