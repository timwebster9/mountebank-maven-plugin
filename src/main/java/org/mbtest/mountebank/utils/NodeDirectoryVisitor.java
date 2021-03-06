package org.mbtest.mountebank.utils;

import lombok.Getter;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

public class NodeDirectoryVisitor extends SimpleFileVisitor<Path> {
    @Getter
    private File result = null;

    @Override
    public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attributes) {
        if (file.getFileName().toString().contains("node")) {
            this.result = file.toFile();
            return TERMINATE;
        }
        return CONTINUE;
    }
}
