__author__ = 'Cedric Zhuang'


dna_to_rna = dict(zip("GCTA", "CGAU"))


def to_rna(dna):
    return ''.join(dna_to_rna[i] for i in dna)
