package at.jku.isse.ecco.plugin.artifact.image;

import at.jku.isse.ecco.plugin.artifact.ArtifactReader;
import at.jku.isse.ecco.plugin.artifact.ArtifactViewer;
import at.jku.isse.ecco.plugin.artifact.ArtifactWriter;
import at.jku.isse.ecco.tree.Node;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

import java.nio.file.Path;
import java.util.Set;

public class ImageModule extends AbstractModule {

	@Override
	protected void configure() {
		final Multibinder<ArtifactReader<Path, Set<Node>>> readerMultibinder = Multibinder.newSetBinder(binder(),
				new TypeLiteral<ArtifactReader<Path, Set<Node>>>() {
				});
		readerMultibinder.addBinding().to(ImageReader.class);

		final Multibinder<ArtifactWriter<Set<Node>, Path>> writerMultibinder = Multibinder.newSetBinder(binder(),
				new TypeLiteral<ArtifactWriter<Set<Node>, Path>>() {
				});
		writerMultibinder.addBinding().to(ImageWriter.class);

		final Multibinder<ArtifactViewer> viewerMultibinder = Multibinder.newSetBinder(binder(),
				new TypeLiteral<ArtifactViewer>() {
				});
		viewerMultibinder.addBinding().to(ImageViewer.class);
	}

}
