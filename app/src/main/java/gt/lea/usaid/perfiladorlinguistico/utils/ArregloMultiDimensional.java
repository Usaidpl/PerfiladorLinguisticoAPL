package gt.lea.usaid.perfiladorlinguistico.utils;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by programadormd on 07-22-16.
 */
public class ArregloMultiDimensional {

        public static final  int[][][] matrices3 = {
                {{1,2,3},{2,4,6},{3,6,9}},
                {{4,8,12},{5,10,15},{6,12,18}}
        };
        public static final class ArregloPrecision
        {
                public static int[][][] IMAGENES = {
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
                        },
                        {

                                {R.mipmap.elote, R.mipmap.zanahoria, R.mipmap.banano},
                                {R.mipmap.carro,R.mipmap.camioneta, R.mipmap.camioncito},
                                {R.mipmap.carro, R.mipmap.carreta, R.mipmap.mototaxi},
                                {R.mipmap.falda, R.mipmap.calceta, R.mipmap.pantalon},
                                {R.mipmap.blusa, R.mipmap.vestido, R.mipmap.pantalon},
                                {R.mipmap.sombrero, R.mipmap.zapato, R.mipmap.guante},
                                {R.mipmap.gorra, R.mipmap.sombrilla, R.mipmap.sombrero},
                                {R.mipmap.pollito, R.mipmap.pato, R.mipmap.pavo},
                                {R.mipmap.conejo, R.mipmap.perro, R.mipmap.gato},
                                {R.mipmap.caballlo,R.mipmap.oveja, R.mipmap.vaca},
                                {R.mipmap.arbol, R.mipmap.rosa, R.mipmap.milpa},
                                {R.mipmap.ejote, R.mipmap.elote, R.mipmap.ayote},
                                {R.mipmap.cama, R.mipmap.mesa, R.mipmap.silla},
                                {R.mipmap.escalera, R.mipmap.cubeta, R.mipmap.banco},
                                {R.mipmap.canasto, R.mipmap.soplador, R.mipmap.caja},
                                {R.mipmap.peine, R.mipmap.cepillo, R.mipmap.logolea},
                                {R.mipmap.lapiz, R.mipmap.sacapuntas, R.mipmap.libro},
                                {R.mipmap.bicicleta, R.mipmap.moto, R.mipmap.mototaxi}
                        }
                };

                public static final int[][] TEXTOS ={
                        {R.string.iii_pato1_sp, R.string.iii_gato2_sp, R.string.iii_vaca3_sp,
                        R.string.iii_arbol4_sp,	R.string.iii_elote5_sp,	R.string.iii_banano6_sp,
                        R.string.iii_camioneta7_sp,	R.string.iii_carro8_sp,	R.string.iii_pantalon9_sp,
                        R.string.iii_vestido10_sp,	R.string.iii_zapato11_sp,	R.string.iii_sombrero12_sp,
                        R.string.iii_mesa13_sp,R.string.iii_escalera14_sp,R.string.iii_canasta15_sp,
                        R.string.iii_peine16_sp, R.string.iii_libro17_sp, R.string.iii_bicicleta18_sp },
                        //inicio vector kiche
                        {R.string.tat_1_kch, R.string.nan_2_kch, R.string.ali_3_kch, R.string.ti_4_kch,
                                R.string.man_5_kch, R.string.aq_6_kch, R.string.imul_7_kch, R.string.chij_8_kch,
                                R.string.pix_9_kch, R.string.aj_10_kch, R.string.oj_11_kch, R.string.wuj_12_kch,
                                R.string.ti_job_13_kch, R.string.tem_14_kch, R.string.pas_15_kch, R.string.up_16_kch,
                                R.string.laq_17_kch, R.string.xot_18_kch}};
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
                        //Segundo vector
                        //-- idioma Man --
                        {R.string.interaccion, R.string.i_respuesta_man, R.string.i_pregunta_uno_man,
                                R.string.i_pregunta_dos_man, R.string.i_pregunta_tres_man, R.string.i_pregunta_cuantro_man,
                                R.string.i_pregunta_cinco_man},
                        //--idioma español --
                        {R.string.Ins_MamEsp_SerE_I, R.string.RespuestaCorrecta_Esp,
                                R.string.Pre1_MamEsp_SerE_I, R.string.Pre2_MamEsp_SerE_I, R.string.Pre3_MamEsp_SerE_I,
                                R.string.Pre4_MamEsp_SerE_I, R.string.Pre5_MamEsp_SerE_I}};
        }
}