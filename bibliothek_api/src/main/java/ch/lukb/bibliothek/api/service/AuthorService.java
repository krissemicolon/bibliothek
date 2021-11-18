package ch.lukb.bibliothek.api.service;

import ch.lukb.bibliothek.api.dao.AbstractDAO;
import ch.lukb.bibliothek.api.scheme.Author;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;

@Service
public class AuthorService extends AbstractService<Author> {
    public AuthorService(AbstractDAO<Author> dao) {
        dao.update(
            new Author(
                    "Kris",
                    "Huber",
                    LocalDate.of(2004, Month.APRIL, 21),
                    ""
            )
        );

        dao.update(
                new Author(
                        "Donald",
                        "Knuth",
                        LocalDate.of(1938, Month.JANUARY, 10),
                        ""
                )
        );

        dao.update(
                new Author(
                        "Niklaus",
                        "Wirth",
                        LocalDate.of(1934, Month.FEBRUARY, 15),
                        """
                        Niklaus Wirth was Full Professor of Computer Science at the ETH Zurich since 1968. He retired in April 1999.
                        Prof. Wirth took his degree in electrical engineering from the ETH Zurich in 1959. Afterwards, he studied at Laval University, Canada. In 1963 he received his doctorate under Prof. H.D. Huskey at the University of California in Berkeley with a scholarship from the Ford Foundation. From 1963 to 1967 he taught as an Assistant Professor at Stanford University and later at the University of Zurich. In 1968 he was appointed full Professor of Computer Science at the ETH Zurich. His chief interests were in software engineering and its tools, in particular programming languages. In 1970 he devised the language Pascal, in 1980 Modula-​2, and in 1988 Oberon. He designed the Lilith computer and in 1986 the Ceres computer. Subsequently, he became involved in the construction of tools for circuit design with programmable components.
                        Prof. Wirth is a member of the Association for Computing Machinery (acm), the Computer Society (IEEE), the Swiss Academy of Technical Sciences (SATW), the US National Academy of Engineering, the Berlin-​Brandenburg Academy and the Orden pour le mérite. He has been awarded honorary doctorates by the Universities of York, Linz, Laval, Novosibirsk and Pretoria, the Open University as well as the ETH Lausanne. In 1984 he received the acm Turing Award and in 1987 the Computer Pioneer award from the IEEE.
                        """
                )
        );

        this.dao = dao;
    }
}
