package gt.lea.usaid.perfiladorlinguistico.utils;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by BryanJuarez on 07-22-16.
 * @author Bryan
 */
public class ArregloMultiDimensional {

        public static final class ArregloPrecision
        {
                public static int[][][] IMAGENES = {
                        //imagenes kiche
                        {
                                {R.mipmap.nino, R.mipmap.senior, R.mipmap.abuelita},//1
                                {R.mipmap.seniora, R.mipmap.nina, R.mipmap.senior},//2
                                {R.mipmap.abuelita, R.mipmap.nina, R.mipmap.nino},//3
                                {R.mipmap.nina, R.mipmap.senior, R.mipmap.abuelita},//4
                                {R.mipmap.abuelo, R.mipmap.abuelita, R.mipmap.nino},//5
                                {R.mipmap.caballlo, R.mipmap.vaca, R.mipmap.cerdo},//6
                                {R.mipmap.gato, R.mipmap.conejo, R.mipmap.perro},//7
                                {R.mipmap.vaca, R.mipmap.oveja, R.mipmap.caballlo},//8
                                {R.mipmap.tomate, R.mipmap.naranja, R.mipmap.pera},//9
                                {R.mipmap.elote, R.mipmap.elote, R.mipmap.ayote},//10
                                {R.mipmap.fresa, R.mipmap.pera, R.mipmap.aguacate},//11
                                {R.mipmap.lapicero, R.mipmap.regla, R.mipmap.cuaderno},//12
                                {R.mipmap.casa, R.mipmap.escuala, R.mipmap.iglesia},//13
                                {R.mipmap.mesa, R.mipmap.silla, R.mipmap.pizarro},//14
                                {R.mipmap.blusa, R.mipmap.falda, R.mipmap.fajatipica},//15
                                {R.mipmap.falda, R.mipmap.pantalon, R.mipmap.fajatipica},//16
                                {R.mipmap.comal, R.mipmap.olla, R.mipmap.sarten},
                                {R.mipmap.logolea, R.mipmap.logolea, R.mipmap.logolea}//17
                        },
                        //man
                        {
                                {R.mipmap.seniora, R.mipmap.nino, R.mipmap.senior},//1
                                {R.mipmap.senior, R.mipmap.nina, R.mipmap.nino},//2
                                {R.mipmap.nina, R.mipmap.nino, R.mipmap.abuelita},//3
                                {R.mipmap.gato, R.mipmap.perro, R.mipmap.caballlo},//4
                                {R.mipmap.logolea, R.mipmap.pavo, R.mipmap.pato},//5
                                {R.mipmap.pato, R.mipmap.gallina, R.mipmap.colibri},//6
                                {R.mipmap.perro, R.mipmap.caballlo, R.mipmap.gato},//7
                                {R.mipmap.caballlo, R.mipmap.oveja, R.mipmap.vaca},//8
                                {R.mipmap.milpa, R.mipmap.rosa, R.mipmap.arbol},//9
                                {R.mipmap.chilepimiento, R.mipmap.zanahoria, R.mipmap.cebolla},//10
                                {R.mipmap.milpa, R.mipmap.pino, R.mipmap.plantabanano},//11
                                {R.mipmap.banano, R.mipmap.zanahoria, R.mipmap.elote},//12
                                {R.mipmap.milpa, R.mipmap.flor, R.mipmap.arbol},//13
                                {R.mipmap.camisa, R.mipmap.vestido, R.mipmap.pantalon},//14
                                {R.mipmap.sandalia, R.mipmap.fajatipica, R.mipmap.cincho},//15
                                {R.mipmap.jarra, R.mipmap.olla, R.mipmap.comal},//16
                                {R.mipmap.comal, R.mipmap.olla, R.mipmap.vaso},//17
                                {R.mipmap.canasto, R.mipmap.palangana, R.mipmap.soplador}//18
                        },
                        {
                                {R.mipmap.pollito, R.mipmap.pato, R.mipmap.pavo},
                                {R.mipmap.conejo, R.mipmap.perro, R.mipmap.gato},
                                {R.mipmap.caballlo,R.mipmap.oveja, R.mipmap.vaca},
                                {R.mipmap.arbol, R.mipmap.rosa, R.mipmap.milpa},
                                {R.mipmap.ejote, R.mipmap.elote, R.mipmap.ayote},
                                {R.mipmap.elote, R.mipmap.zanahoria, R.mipmap.banano},
                                {R.mipmap.carro,R.mipmap.camioneta, R.mipmap.camioncito},
                                {R.mipmap.carro, R.mipmap.carreta, R.mipmap.mototaxi},
                                {R.mipmap.falda, R.mipmap.calceta, R.mipmap.pantalon},
                                {R.mipmap.blusa, R.mipmap.vestido, R.mipmap.pantalon},
                                {R.mipmap.sombrero, R.mipmap.zapato, R.mipmap.guante},
                                {R.mipmap.gorra, R.mipmap.sombrilla, R.mipmap.sombrero},
                                {R.mipmap.cama, R.mipmap.mesa, R.mipmap.silla},
                                {R.mipmap.escalera, R.mipmap.cubeta, R.mipmap.banco},
                                {R.mipmap.canasto, R.mipmap.soplador, R.mipmap.caja},
                                {R.mipmap.peine, R.mipmap.cepillo, R.mipmap.logolea},
                                {R.mipmap.lapiz, R.mipmap.sacapuntas, R.mipmap.libro},
                                {R.mipmap.bicicleta, R.mipmap.moto, R.mipmap.mototaxi}
                        }

                };

                public static final int[][] TEXTOS ={
                        //inicio vector kiche
                        {R.string.tat_1_kch, R.string.nan_2_kch, R.string.ali_3_kch, R.string.ti_4_kch,
                                R.string.man_5_kch, R.string.aq_6_kch, R.string.imul_7_kch, R.string.chij_8_kch,
                                R.string.pix_9_kch, R.string.aj_10_kch, R.string.oj_11_kch, R.string.wuj_12_kch,
                                R.string.ti_job_13_kch, R.string.tem_14_kch, R.string.pas_15_kch, R.string.up_16_kch,
                                R.string.laq_17_kch, R.string.xot_18_kch},
                        //man
                        {R.string.iii_tat_1_mn, R.string.iii_txin_2_mn, R.string.iii_nam_ya_3_mn,
                                R.string.iii_tx_4_mn, R.string.iii_chmek_5_mn, R.string.iii_ek_6_mn,
                                R.string.iii_wix_7_mn, R.string.iii_chej_8_mn, R.string.iii_tze_9_mn,
                                R.string.iii_ich_10_mn, R.string.iii_kjo_11_mn, R.string.iii_ix_12_mn,
                                R.string.iii_bech_13_mn, R.string.iii_wexj_14_mn, R.string.iii_xjab_15,
                                R.string.iii_xkon_16_mn, R.string.iii_kil_17_mn, R.string.iii_chil_18_mn},
                        //Español
                        {R.string.iii_pato1_sp, R.string.iii_gato2_sp, R.string.iii_vaca3_sp,
                        R.string.iii_arbol4_sp,	R.string.iii_elote5_sp,	R.string.iii_banano6_sp,
                        R.string.iii_camioneta7_sp,	R.string.iii_carro8_sp,	R.string.iii_pantalon9_sp,
                        R.string.iii_vestido10_sp,	R.string.iii_zapato11_sp,	R.string.iii_sombrero12_sp,
                        R.string.iii_mesa13_sp,R.string.iii_escalera14_sp,R.string.iii_canasta15_sp,
                        R.string.iii_peine16_sp, R.string.iii_libro17_sp, R.string.iii_bicicleta18_sp }
                       };
        }

        public static final class ArregloComprension
        {
                public static final int TEXTOS[][] =
                        {{R.string.tituto_dos_kiche, R.string.i_respusta_correcta_kiche,R.string.ii_pregunta_uno_kiche,
                                R.string.ii_pregunta_dos_kiche, R.string.ii_pregunta_tres_kiche, R.string.ii_pregunta_cuatro_kiche,
                                R.string.ii_pregunta_cinco_kiche},
                                {R.string.comprension, R.string.i_respuesta_man, R.string.ii_pregunta_uno_man,
                                        R.string.ii_pregunta_dos_man, R.string.ii_pregunta_tres_man, R.string.ii_pregunta_cuatro_man,
                                        R.string.ii_pregunta_cinco_man},
                                {R.string.comprension_sp, R.string.respuesta_sp,
                                        R.string.ii_pregunta_uno_sp, R.string.ii_pregunta_dos_sp,
                                        R.string.ii_pregunta_tres_sp, R.string.ii_pregunta_cuatro_sp, R.string.ii_pregunta_cinco_sp}};
        }

        public static final class ArregloInteraccion
        {
                public static final int TEXTOS[][] = {
                        //-- idioma Quiche --
                        {R.string.guia_kiche, R.string.i_respusta_correcta_kiche,
                                R.string.i_pregunta_uno_kiche, R.string.i_pregunta_dos_kiche,
                                R.string.i_pregunta_tres_kiche, R.string.i_pregunta_cuatro_kiche,
                                R.string.i_pregunta_cinco_kiche},
                        //-- idioma Man --
                        {R.string.interaccion_man, R.string.i_respuesta_man, R.string.i_pregunta_uno_man,
                                R.string.i_pregunta_dos_man, R.string.i_pregunta_tres_man, R.string.i_pregunta_cuantro_man,
                                R.string.i_pregunta_cinco_man},
                        //Segundo vector

                        //--idioma español --
                        {R.string.Ins_MamEsp_SerE_I, R.string.RespuestaCorrecta_Esp,
                                R.string.Pre1_MamEsp_SerE_I, R.string.Pre2_MamEsp_SerE_I, R.string.Pre3_MamEsp_SerE_I,
                                R.string.Pre4_MamEsp_SerE_I, R.string.Pre5_MamEsp_SerE_I}};
        }
}
