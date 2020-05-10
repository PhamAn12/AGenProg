package Population;

import GzFaulocalization.FaulResult;

import java.io.IOException;
import java.util.List;

public class AutoAddFile {
    private FaulResult faulResult;
    public AutoAddFile (FaulResult faulResult) {
        this.faulResult = faulResult;
    }
    String desPathForTest = "D:\\thsi\\src\\main\\AutoGenerateFolder\\";
    public void CreateFolderForTest() throws IOException {
        VariantFinder vf = new VariantFinder(faulResult);
        //System.out.println(vf.GetContextOfVariant(GetBuggyPathFile.GetAbsolutePath("Buggy2.MidFuction2")));
        List<Variant> lv = vf.InitFirstVariant();
        for(Variant variant : lv) {
            System.out.println(variant.getClassName());
            System.out.println(variant.getPathToVariant());
            FileModifiedDir.moveFileDir(variant.getPathToVariant(),desPathForTest);

        }
    }
    public void CreateFolderTest(String pathToTestCase) {
        FileModifiedDir.moveFileDir(pathToTestCase,desPathForTest);
    }

}
