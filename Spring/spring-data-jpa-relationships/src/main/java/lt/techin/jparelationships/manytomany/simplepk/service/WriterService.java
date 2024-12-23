package lt.techin.jparelationships.manytomany.simplepk.service;

import lt.techin.jparelationships.manytomany.simplepk.model.Writer;

public interface WriterService {

    Writer validateAndGetWriter(Long id);

    Writer saveWriter(Writer writer);

    void deleteWriter(Writer writer);
}
