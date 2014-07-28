    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */

    package myclass;

    import com.sun.tools.javac.main.JavaCompiler;
    import com.sun.tools.javac.tree.JCTree;
    import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
    import com.sun.tools.javac.util.Context;
    import java.io.File;
    import java.io.IOException;
    import static java.lang.System.exit;
    import java.util.ArrayList;
import java.util.Locale;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.tools.JavaFileManager;
    import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import static javax.tools.StandardLocation.CLASS_PATH;
    import static javax.tools.StandardLocation.SOURCE_OUTPUT;
    import static javax.tools.StandardLocation.SOURCE_PATH;
    import javax.tools.ToolProvider;

    /**
     *
     * @author guestu
     */
    public class MyClass extends JavaCompiler {
        
        public MyClass(Context cntxt) {
            super(cntxt);
        } 
        
        public static Context contexts = new Context();

        public static void main(String[] args) throws IOException {
          
           try {
               
                javax.tools.JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                
                StandardJavaFileManager stdFileManager = compiler.getStandardFileManager(null, Locale.getDefault(), null);
                
               
                JavaFileObject compilationUnits = stdFileManager.getJavaFileForInput(SOURCE_PATH, "GeneratedClass.java", JavaFileObject.Kind.SOURCE);
                
                System.out.printf("%s", compilationUnits); 
       
                MyClass cy = new MyClass(contexts);
                
                cy.parse(compilationUnits); //line 46                
                
            } catch (IOException ex) {
                System.out.println("Exception thrown  :" + ex);
                Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }            

        @Override
        public JCTree.JCCompilationUnit parse(JavaFileObject filename){
            return super.parse(filename); //line 57
        }     

        @Override
        protected JCCompilationUnit parse(JavaFileObject filename, CharSequence readSource) {

                return super.parse(filename, readSource);
        }  
    }
