package lt.techin.jparelationships.manytomany.simplepk.service;

import lt.techin.jparelationships.manytomany.simplepk.exception.WriterNotFoundException;
import lt.techin.jparelationships.manytomany.simplepk.model.Writer;
import lt.techin.jparelationships.manytomany.simplepk.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    @Override
    public Writer validateAndGetWriter(Long id) {
        return writerRepository.findById(id).orElseThrow(() -> new WriterNotFoundException(id));
    }

    @Override
    public Writer saveWriter(Writer writer) {
        return writerRepository.save(writer);
    }

    @Override
    public void deleteWriter(Writer writer) {
        writerRepository.delete(writer);
    }
}
