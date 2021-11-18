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
                        "Donald",
                        "Knuth",
                        LocalDate.of(1938, Month.JANUARY, 10),
                        """
                                Donald Knuth was born in 1938 in Milwaukee, Wisconsin, and holds a BS and MS in mathematics from the Case Institute of Technology (1960) and a PhD in mathematics (1963) from Caltech. Over a prolific publishing career, Knuth is best known for having written the classic, multivolume series, The Art of Computer Programming, the "Bible" of computer science pedagogy. Through his writing and teaching at Stanford University, where he was a long-time professor (beginning in 1968), Knuth has influenced the thinking of countless computer science students and professionals.
                                Knuth's lifelong love affair with computers began as an undergraduate when he discovered the IBM 650 computer system at Case. He quickly mastered the inner workings of the machine and developed a novel program to automate coaching of the school's basketball team, earning him an appearance on the CBS Evening News with Walter Cronkite.
                                In 1976, Knuth invented the typesetting language TeX when he grew frustrated with the poor quality of typography proposed for an upcoming new volume of The Art of Computer Programming. TeX remains a worldwide standard for technical publishing.
                                Knuth has won dozens of awards, including the ACM Turing Award (1974), the National Medal of Science (1979), and the Kyoto Prize (1996).
                        """
                )
        );

        dao.update(
                new Author(
                        "Dennis",
                        "Ritchie",
                        LocalDate.of(1941, Month.SEPTEMBER, 9),
                        """
                        Dennis Ritchie was born in Bronxville, New York, in 1941. He graduated from Harvard University with degrees in physics and applied mathematics and with a PhD in mathematics (1968). His contributions to computing span four decades and have had global impact. While at Bell Labs' Computing Sciences Research Center in the early 1970s, he created the C programming language and codeveloped (with Ken Thompson) the UNIX operating system-both of which are foundations of our modern digital world.
                        The C programming language and its descendants continue to be used to write the software that makes digital devices and networks work, while UNIX and UNIX-like operating systems run on a vast range of computing systems.
                        Ritchie's early work laid the foundations for much of the technical infrastructure of our modern digital world. He enjoyed traveling and reading, but his main passion was his work, and he stayed with Bell Labs until his retirement in 2007. With Ken Thompson, he was awarded the ACM Turing Award (1983), the US National Medal of Technology (1999), and the Japan Prize (2011). He passed away in 2011.
                        """
                )
        );

        dao.update(
                new Author(
                        "Simon",
                        "Jones",
                        LocalDate.of(1958, Month.JANUARY, 18),
                        """
                                Peyton Jones worked in industry for two years before serving as a lecturer at University College London and, from 1990 to 1998, as a professor at the University of Glasgow.[6] Since 1998 he has worked as a researcher at Microsoft Research in Cambridge, England.[6][8][9]
                                He is a major contributor to the design of the Haskell programming language,[10] and a lead developer of the Glasgow Haskell Compiler (GHC).[11] He is also co-creator of the C-- programming language, designed for intermediate program representation between the language-specific front-end of a compiler and a general-purpose back-end code generator and optimiser. C-- is used in GHC.[12][13][14]
                                He was also a major contributor to the 1999 book Cybernauts Awake,[15] which explored the ethical and spiritual implications of the Internet.
                                Peyton Jones chairs the Computing At School (CAS) group,[3] an organisation which aims to promote the teaching of computer science at school. Following these efforts, in 2019 he was appointed chair of the newly founded UK National Centre for Computing Education.[16]
                        """
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

        dao.update(
                new Author(
                        "Clifford",
                        "Stein",
                        LocalDate.of(1953, Month.NOVEMBER, 10),
                        """
                                Charles Eric Leiserson is a computer scientist, specializing in the theory of parallel computing and distributed computing, and particularly practical applications thereof. As part of this effort, he developed the Cilk multithreaded language. He invented the fat-tree interconnection network, a hardware-universal interconnection network used in many supercomputers, including the Connection Machine CM5, for which he was network architect. He helped pioneer the development of VLSI theory, including the retiming method of digital optimization with James B. Saxe and systolic arrays with H. T. Kung. He conceived of the notion of cache-oblivious algorithms, which are algorithms that have no tuning parameters for cache size or cache-line length, but nevertheless use cache near-optimally. He developed the Cilk language for multithreaded programming, which uses a provably good work-stealing algorithm for scheduling. Leiserson coauthored the standard algorithms textbook Introduction to Algorithms together with Thomas H. Cormen, Ronald L. Rivest, and Clifford Stein.
                        """

                )
        );

        this.dao = dao;
    }
}
