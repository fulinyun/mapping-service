package test;

import java.io.FileInputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class ttlTest {

	public static void main(String[] args) throws Exception {
		Model model = ModelFactory.createDefaultModel();
		FileInputStream fstream = new FileInputStream("nims.ttl");
		model.read(fstream, "", "TTL");
		fstream.close();
		for (StmtIterator i = model.listStatements(); i.hasNext(); ) System.out.println(i.next().toString());
		model.removeAll();
		
		fstream = new FileInputStream("gcmd-sciencekeywords.rdf");
		model.read(fstream, "", "RDF");
		fstream.close();
		for (StmtIterator i = model.listStatements(); i.hasNext(); ) System.out.println(i.next().toString());		
		model.close();
		
	}
}
