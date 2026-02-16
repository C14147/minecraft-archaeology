package org.lwjgl.opengl;

import java.util.HashSet;
import java.util.Set;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/opengl/ContextCapabilities.class */
public class ContextCapabilities {
    static final boolean DEBUG = false;
    final APIUtil util = new APIUtil();
    final StateTracker tracker = new StateTracker();
    public final boolean GL_AMD_blend_minmax_factor;
    public final boolean GL_AMD_conservative_depth;
    public final boolean GL_AMD_debug_output;
    public final boolean GL_AMD_depth_clamp_separate;
    public final boolean GL_AMD_draw_buffers_blend;
    public final boolean GL_AMD_interleaved_elements;
    public final boolean GL_AMD_multi_draw_indirect;
    public final boolean GL_AMD_name_gen_delete;
    public final boolean GL_AMD_performance_monitor;
    public final boolean GL_AMD_pinned_memory;
    public final boolean GL_AMD_query_buffer_object;
    public final boolean GL_AMD_sample_positions;
    public final boolean GL_AMD_seamless_cubemap_per_texture;
    public final boolean GL_AMD_shader_atomic_counter_ops;
    public final boolean GL_AMD_shader_stencil_export;
    public final boolean GL_AMD_shader_trinary_minmax;
    public final boolean GL_AMD_sparse_texture;
    public final boolean GL_AMD_stencil_operation_extended;
    public final boolean GL_AMD_texture_texture4;
    public final boolean GL_AMD_transform_feedback3_lines_triangles;
    public final boolean GL_AMD_vertex_shader_layer;
    public final boolean GL_AMD_vertex_shader_tessellator;
    public final boolean GL_AMD_vertex_shader_viewport_index;
    public final boolean GL_APPLE_aux_depth_stencil;
    public final boolean GL_APPLE_client_storage;
    public final boolean GL_APPLE_element_array;
    public final boolean GL_APPLE_fence;
    public final boolean GL_APPLE_float_pixels;
    public final boolean GL_APPLE_flush_buffer_range;
    public final boolean GL_APPLE_object_purgeable;
    public final boolean GL_APPLE_packed_pixels;
    public final boolean GL_APPLE_rgb_422;
    public final boolean GL_APPLE_row_bytes;
    public final boolean GL_APPLE_texture_range;
    public final boolean GL_APPLE_vertex_array_object;
    public final boolean GL_APPLE_vertex_array_range;
    public final boolean GL_APPLE_vertex_program_evaluators;
    public final boolean GL_APPLE_ycbcr_422;
    public final boolean GL_ARB_ES2_compatibility;
    public final boolean GL_ARB_ES3_1_compatibility;
    public final boolean GL_ARB_ES3_compatibility;
    public final boolean GL_ARB_arrays_of_arrays;
    public final boolean GL_ARB_base_instance;
    public final boolean GL_ARB_bindless_texture;
    public final boolean GL_ARB_blend_func_extended;
    public final boolean GL_ARB_buffer_storage;
    public final boolean GL_ARB_cl_event;
    public final boolean GL_ARB_clear_buffer_object;
    public final boolean GL_ARB_clear_texture;
    public final boolean GL_ARB_clip_control;
    public final boolean GL_ARB_color_buffer_float;
    public final boolean GL_ARB_compatibility;
    public final boolean GL_ARB_compressed_texture_pixel_storage;
    public final boolean GL_ARB_compute_shader;
    public final boolean GL_ARB_compute_variable_group_size;
    public final boolean GL_ARB_conditional_render_inverted;
    public final boolean GL_ARB_conservative_depth;
    public final boolean GL_ARB_copy_buffer;
    public final boolean GL_ARB_copy_image;
    public final boolean GL_ARB_cull_distance;
    public final boolean GL_ARB_debug_output;
    public final boolean GL_ARB_depth_buffer_float;
    public final boolean GL_ARB_depth_clamp;
    public final boolean GL_ARB_depth_texture;
    public final boolean GL_ARB_derivative_control;
    public final boolean GL_ARB_direct_state_access;
    public final boolean GL_ARB_draw_buffers;
    public final boolean GL_ARB_draw_buffers_blend;
    public final boolean GL_ARB_draw_elements_base_vertex;
    public final boolean GL_ARB_draw_indirect;
    public final boolean GL_ARB_draw_instanced;
    public final boolean GL_ARB_enhanced_layouts;
    public final boolean GL_ARB_explicit_attrib_location;
    public final boolean GL_ARB_explicit_uniform_location;
    public final boolean GL_ARB_fragment_coord_conventions;
    public final boolean GL_ARB_fragment_layer_viewport;
    public final boolean GL_ARB_fragment_program;
    public final boolean GL_ARB_fragment_program_shadow;
    public final boolean GL_ARB_fragment_shader;
    public final boolean GL_ARB_framebuffer_no_attachments;
    public final boolean GL_ARB_framebuffer_object;
    public final boolean GL_ARB_framebuffer_sRGB;
    public final boolean GL_ARB_geometry_shader4;
    public final boolean GL_ARB_get_program_binary;
    public final boolean GL_ARB_get_texture_sub_image;
    public final boolean GL_ARB_gpu_shader5;
    public final boolean GL_ARB_gpu_shader_fp64;
    public final boolean GL_ARB_half_float_pixel;
    public final boolean GL_ARB_half_float_vertex;
    public final boolean GL_ARB_imaging;
    public final boolean GL_ARB_indirect_parameters;
    public final boolean GL_ARB_instanced_arrays;
    public final boolean GL_ARB_internalformat_query;
    public final boolean GL_ARB_internalformat_query2;
    public final boolean GL_ARB_invalidate_subdata;
    public final boolean GL_ARB_map_buffer_alignment;
    public final boolean GL_ARB_map_buffer_range;
    public final boolean GL_ARB_matrix_palette;
    public final boolean GL_ARB_multi_bind;
    public final boolean GL_ARB_multi_draw_indirect;
    public final boolean GL_ARB_multisample;
    public final boolean GL_ARB_multitexture;
    public final boolean GL_ARB_occlusion_query;
    public final boolean GL_ARB_occlusion_query2;
    public final boolean GL_ARB_pipeline_statistics_query;
    public final boolean GL_ARB_pixel_buffer_object;
    public final boolean GL_ARB_point_parameters;
    public final boolean GL_ARB_point_sprite;
    public final boolean GL_ARB_program_interface_query;
    public final boolean GL_ARB_provoking_vertex;
    public final boolean GL_ARB_query_buffer_object;
    public final boolean GL_ARB_robust_buffer_access_behavior;
    public final boolean GL_ARB_robustness;
    public final boolean GL_ARB_robustness_isolation;
    public final boolean GL_ARB_sample_shading;
    public final boolean GL_ARB_sampler_objects;
    public final boolean GL_ARB_seamless_cube_map;
    public final boolean GL_ARB_seamless_cubemap_per_texture;
    public final boolean GL_ARB_separate_shader_objects;
    public final boolean GL_ARB_shader_atomic_counters;
    public final boolean GL_ARB_shader_bit_encoding;
    public final boolean GL_ARB_shader_draw_parameters;
    public final boolean GL_ARB_shader_group_vote;
    public final boolean GL_ARB_shader_image_load_store;
    public final boolean GL_ARB_shader_image_size;
    public final boolean GL_ARB_shader_objects;
    public final boolean GL_ARB_shader_precision;
    public final boolean GL_ARB_shader_stencil_export;
    public final boolean GL_ARB_shader_storage_buffer_object;
    public final boolean GL_ARB_shader_subroutine;
    public final boolean GL_ARB_shader_texture_image_samples;
    public final boolean GL_ARB_shader_texture_lod;
    public final boolean GL_ARB_shading_language_100;
    public final boolean GL_ARB_shading_language_420pack;
    public final boolean GL_ARB_shading_language_include;
    public final boolean GL_ARB_shading_language_packing;
    public final boolean GL_ARB_shadow;
    public final boolean GL_ARB_shadow_ambient;
    public final boolean GL_ARB_sparse_buffer;
    public final boolean GL_ARB_sparse_texture;
    public final boolean GL_ARB_stencil_texturing;
    public final boolean GL_ARB_sync;
    public final boolean GL_ARB_tessellation_shader;
    public final boolean GL_ARB_texture_barrier;
    public final boolean GL_ARB_texture_border_clamp;
    public final boolean GL_ARB_texture_buffer_object;
    public final boolean GL_ARB_texture_buffer_object_rgb32;
    public final boolean GL_ARB_texture_buffer_range;
    public final boolean GL_ARB_texture_compression;
    public final boolean GL_ARB_texture_compression_bptc;
    public final boolean GL_ARB_texture_compression_rgtc;
    public final boolean GL_ARB_texture_cube_map;
    public final boolean GL_ARB_texture_cube_map_array;
    public final boolean GL_ARB_texture_env_add;
    public final boolean GL_ARB_texture_env_combine;
    public final boolean GL_ARB_texture_env_crossbar;
    public final boolean GL_ARB_texture_env_dot3;
    public final boolean GL_ARB_texture_float;
    public final boolean GL_ARB_texture_gather;
    public final boolean GL_ARB_texture_mirror_clamp_to_edge;
    public final boolean GL_ARB_texture_mirrored_repeat;
    public final boolean GL_ARB_texture_multisample;
    public final boolean GL_ARB_texture_non_power_of_two;
    public final boolean GL_ARB_texture_query_levels;
    public final boolean GL_ARB_texture_query_lod;
    public final boolean GL_ARB_texture_rectangle;
    public final boolean GL_ARB_texture_rg;
    public final boolean GL_ARB_texture_rgb10_a2ui;
    public final boolean GL_ARB_texture_stencil8;
    public final boolean GL_ARB_texture_storage;
    public final boolean GL_ARB_texture_storage_multisample;
    public final boolean GL_ARB_texture_swizzle;
    public final boolean GL_ARB_texture_view;
    public final boolean GL_ARB_timer_query;
    public final boolean GL_ARB_transform_feedback2;
    public final boolean GL_ARB_transform_feedback3;
    public final boolean GL_ARB_transform_feedback_instanced;
    public final boolean GL_ARB_transform_feedback_overflow_query;
    public final boolean GL_ARB_transpose_matrix;
    public final boolean GL_ARB_uniform_buffer_object;
    public final boolean GL_ARB_vertex_array_bgra;
    public final boolean GL_ARB_vertex_array_object;
    public final boolean GL_ARB_vertex_attrib_64bit;
    public final boolean GL_ARB_vertex_attrib_binding;
    public final boolean GL_ARB_vertex_blend;
    public final boolean GL_ARB_vertex_buffer_object;
    public final boolean GL_ARB_vertex_program;
    public final boolean GL_ARB_vertex_shader;
    public final boolean GL_ARB_vertex_type_10f_11f_11f_rev;
    public final boolean GL_ARB_vertex_type_2_10_10_10_rev;
    public final boolean GL_ARB_viewport_array;
    public final boolean GL_ARB_window_pos;
    public final boolean GL_ATI_draw_buffers;
    public final boolean GL_ATI_element_array;
    public final boolean GL_ATI_envmap_bumpmap;
    public final boolean GL_ATI_fragment_shader;
    public final boolean GL_ATI_map_object_buffer;
    public final boolean GL_ATI_meminfo;
    public final boolean GL_ATI_pn_triangles;
    public final boolean GL_ATI_separate_stencil;
    public final boolean GL_ATI_shader_texture_lod;
    public final boolean GL_ATI_text_fragment_shader;
    public final boolean GL_ATI_texture_compression_3dc;
    public final boolean GL_ATI_texture_env_combine3;
    public final boolean GL_ATI_texture_float;
    public final boolean GL_ATI_texture_mirror_once;
    public final boolean GL_ATI_vertex_array_object;
    public final boolean GL_ATI_vertex_attrib_array_object;
    public final boolean GL_ATI_vertex_streams;
    public final boolean GL_EXT_Cg_shader;
    public final boolean GL_EXT_abgr;
    public final boolean GL_EXT_bgra;
    public final boolean GL_EXT_bindable_uniform;
    public final boolean GL_EXT_blend_color;
    public final boolean GL_EXT_blend_equation_separate;
    public final boolean GL_EXT_blend_func_separate;
    public final boolean GL_EXT_blend_minmax;
    public final boolean GL_EXT_blend_subtract;
    public final boolean GL_EXT_compiled_vertex_array;
    public final boolean GL_EXT_depth_bounds_test;
    public final boolean GL_EXT_direct_state_access;
    public final boolean GL_EXT_draw_buffers2;
    public final boolean GL_EXT_draw_instanced;
    public final boolean GL_EXT_draw_range_elements;
    public final boolean GL_EXT_fog_coord;
    public final boolean GL_EXT_framebuffer_blit;
    public final boolean GL_EXT_framebuffer_multisample;
    public final boolean GL_EXT_framebuffer_multisample_blit_scaled;
    public final boolean GL_EXT_framebuffer_object;
    public final boolean GL_EXT_framebuffer_sRGB;
    public final boolean GL_EXT_geometry_shader4;
    public final boolean GL_EXT_gpu_program_parameters;
    public final boolean GL_EXT_gpu_shader4;
    public final boolean GL_EXT_multi_draw_arrays;
    public final boolean GL_EXT_packed_depth_stencil;
    public final boolean GL_EXT_packed_float;
    public final boolean GL_EXT_packed_pixels;
    public final boolean GL_EXT_paletted_texture;
    public final boolean GL_EXT_pixel_buffer_object;
    public final boolean GL_EXT_point_parameters;
    public final boolean GL_EXT_provoking_vertex;
    public final boolean GL_EXT_rescale_normal;
    public final boolean GL_EXT_secondary_color;
    public final boolean GL_EXT_separate_shader_objects;
    public final boolean GL_EXT_separate_specular_color;
    public final boolean GL_EXT_shader_image_load_store;
    public final boolean GL_EXT_shadow_funcs;
    public final boolean GL_EXT_shared_texture_palette;
    public final boolean GL_EXT_stencil_clear_tag;
    public final boolean GL_EXT_stencil_two_side;
    public final boolean GL_EXT_stencil_wrap;
    public final boolean GL_EXT_texture_3d;
    public final boolean GL_EXT_texture_array;
    public final boolean GL_EXT_texture_buffer_object;
    public final boolean GL_EXT_texture_compression_latc;
    public final boolean GL_EXT_texture_compression_rgtc;
    public final boolean GL_EXT_texture_compression_s3tc;
    public final boolean GL_EXT_texture_env_combine;
    public final boolean GL_EXT_texture_env_dot3;
    public final boolean GL_EXT_texture_filter_anisotropic;
    public final boolean GL_EXT_texture_integer;
    public final boolean GL_EXT_texture_lod_bias;
    public final boolean GL_EXT_texture_mirror_clamp;
    public final boolean GL_EXT_texture_rectangle;
    public final boolean GL_EXT_texture_sRGB;
    public final boolean GL_EXT_texture_sRGB_decode;
    public final boolean GL_EXT_texture_shared_exponent;
    public final boolean GL_EXT_texture_snorm;
    public final boolean GL_EXT_texture_swizzle;
    public final boolean GL_EXT_timer_query;
    public final boolean GL_EXT_transform_feedback;
    public final boolean GL_EXT_vertex_array_bgra;
    public final boolean GL_EXT_vertex_attrib_64bit;
    public final boolean GL_EXT_vertex_shader;
    public final boolean GL_EXT_vertex_weighting;
    public final boolean OpenGL11;
    public final boolean OpenGL12;
    public final boolean OpenGL13;
    public final boolean OpenGL14;
    public final boolean OpenGL15;
    public final boolean OpenGL20;
    public final boolean OpenGL21;
    public final boolean OpenGL30;
    public final boolean OpenGL31;
    public final boolean OpenGL32;
    public final boolean OpenGL33;
    public final boolean OpenGL40;
    public final boolean OpenGL41;
    public final boolean OpenGL42;
    public final boolean OpenGL43;
    public final boolean OpenGL44;
    public final boolean OpenGL45;
    public final boolean GL_GREMEDY_frame_terminator;
    public final boolean GL_GREMEDY_string_marker;
    public final boolean GL_HP_occlusion_test;
    public final boolean GL_IBM_rasterpos_clip;
    public final boolean GL_INTEL_map_texture;
    public final boolean GL_KHR_context_flush_control;
    public final boolean GL_KHR_debug;
    public final boolean GL_KHR_robust_buffer_access_behavior;
    public final boolean GL_KHR_robustness;
    public final boolean GL_KHR_texture_compression_astc_ldr;
    public final boolean GL_NVX_gpu_memory_info;
    public final boolean GL_NV_bindless_multi_draw_indirect;
    public final boolean GL_NV_bindless_texture;
    public final boolean GL_NV_blend_equation_advanced;
    public final boolean GL_NV_blend_square;
    public final boolean GL_NV_compute_program5;
    public final boolean GL_NV_conditional_render;
    public final boolean GL_NV_copy_depth_to_color;
    public final boolean GL_NV_copy_image;
    public final boolean GL_NV_deep_texture3D;
    public final boolean GL_NV_depth_buffer_float;
    public final boolean GL_NV_depth_clamp;
    public final boolean GL_NV_draw_texture;
    public final boolean GL_NV_evaluators;
    public final boolean GL_NV_explicit_multisample;
    public final boolean GL_NV_fence;
    public final boolean GL_NV_float_buffer;
    public final boolean GL_NV_fog_distance;
    public final boolean GL_NV_fragment_program;
    public final boolean GL_NV_fragment_program2;
    public final boolean GL_NV_fragment_program4;
    public final boolean GL_NV_fragment_program_option;
    public final boolean GL_NV_framebuffer_multisample_coverage;
    public final boolean GL_NV_geometry_program4;
    public final boolean GL_NV_geometry_shader4;
    public final boolean GL_NV_gpu_program4;
    public final boolean GL_NV_gpu_program5;
    public final boolean GL_NV_gpu_program5_mem_extended;
    public final boolean GL_NV_gpu_shader5;
    public final boolean GL_NV_half_float;
    public final boolean GL_NV_light_max_exponent;
    public final boolean GL_NV_multisample_coverage;
    public final boolean GL_NV_multisample_filter_hint;
    public final boolean GL_NV_occlusion_query;
    public final boolean GL_NV_packed_depth_stencil;
    public final boolean GL_NV_parameter_buffer_object;
    public final boolean GL_NV_parameter_buffer_object2;
    public final boolean GL_NV_path_rendering;
    public final boolean GL_NV_pixel_data_range;
    public final boolean GL_NV_point_sprite;
    public final boolean GL_NV_present_video;
    public final boolean GL_NV_primitive_restart;
    public final boolean GL_NV_register_combiners;
    public final boolean GL_NV_register_combiners2;
    public final boolean GL_NV_shader_atomic_counters;
    public final boolean GL_NV_shader_atomic_float;
    public final boolean GL_NV_shader_buffer_load;
    public final boolean GL_NV_shader_buffer_store;
    public final boolean GL_NV_shader_storage_buffer_object;
    public final boolean GL_NV_tessellation_program5;
    public final boolean GL_NV_texgen_reflection;
    public final boolean GL_NV_texture_barrier;
    public final boolean GL_NV_texture_compression_vtc;
    public final boolean GL_NV_texture_env_combine4;
    public final boolean GL_NV_texture_expand_normal;
    public final boolean GL_NV_texture_multisample;
    public final boolean GL_NV_texture_rectangle;
    public final boolean GL_NV_texture_shader;
    public final boolean GL_NV_texture_shader2;
    public final boolean GL_NV_texture_shader3;
    public final boolean GL_NV_transform_feedback;
    public final boolean GL_NV_transform_feedback2;
    public final boolean GL_NV_vertex_array_range;
    public final boolean GL_NV_vertex_array_range2;
    public final boolean GL_NV_vertex_attrib_integer_64bit;
    public final boolean GL_NV_vertex_buffer_unified_memory;
    public final boolean GL_NV_vertex_program;
    public final boolean GL_NV_vertex_program1_1;
    public final boolean GL_NV_vertex_program2;
    public final boolean GL_NV_vertex_program2_option;
    public final boolean GL_NV_vertex_program3;
    public final boolean GL_NV_vertex_program4;
    public final boolean GL_NV_video_capture;
    public final boolean GL_SGIS_generate_mipmap;
    public final boolean GL_SGIS_texture_lod;
    public final boolean GL_SUN_slice_accum;
    long glDebugMessageEnableAMD;
    long glDebugMessageInsertAMD;
    long glDebugMessageCallbackAMD;
    long glGetDebugMessageLogAMD;
    long glBlendFuncIndexedAMD;
    long glBlendFuncSeparateIndexedAMD;
    long glBlendEquationIndexedAMD;
    long glBlendEquationSeparateIndexedAMD;
    long glVertexAttribParameteriAMD;
    long glMultiDrawArraysIndirectAMD;
    long glMultiDrawElementsIndirectAMD;
    long glGenNamesAMD;
    long glDeleteNamesAMD;
    long glIsNameAMD;
    long glGetPerfMonitorGroupsAMD;
    long glGetPerfMonitorCountersAMD;
    long glGetPerfMonitorGroupStringAMD;
    long glGetPerfMonitorCounterStringAMD;
    long glGetPerfMonitorCounterInfoAMD;
    long glGenPerfMonitorsAMD;
    long glDeletePerfMonitorsAMD;
    long glSelectPerfMonitorCountersAMD;
    long glBeginPerfMonitorAMD;
    long glEndPerfMonitorAMD;
    long glGetPerfMonitorCounterDataAMD;
    long glSetMultisamplefvAMD;
    long glTexStorageSparseAMD;
    long glTextureStorageSparseAMD;
    long glStencilOpValueAMD;
    long glTessellationFactorAMD;
    long glTessellationModeAMD;
    long glElementPointerAPPLE;
    long glDrawElementArrayAPPLE;
    long glDrawRangeElementArrayAPPLE;
    long glMultiDrawElementArrayAPPLE;
    long glMultiDrawRangeElementArrayAPPLE;
    long glGenFencesAPPLE;
    long glDeleteFencesAPPLE;
    long glSetFenceAPPLE;
    long glIsFenceAPPLE;
    long glTestFenceAPPLE;
    long glFinishFenceAPPLE;
    long glTestObjectAPPLE;
    long glFinishObjectAPPLE;
    long glBufferParameteriAPPLE;
    long glFlushMappedBufferRangeAPPLE;
    long glObjectPurgeableAPPLE;
    long glObjectUnpurgeableAPPLE;
    long glGetObjectParameterivAPPLE;
    long glTextureRangeAPPLE;
    long glGetTexParameterPointervAPPLE;
    long glBindVertexArrayAPPLE;
    long glDeleteVertexArraysAPPLE;
    long glGenVertexArraysAPPLE;
    long glIsVertexArrayAPPLE;
    long glVertexArrayRangeAPPLE;
    long glFlushVertexArrayRangeAPPLE;
    long glVertexArrayParameteriAPPLE;
    long glEnableVertexAttribAPPLE;
    long glDisableVertexAttribAPPLE;
    long glIsVertexAttribEnabledAPPLE;
    long glMapVertexAttrib1dAPPLE;
    long glMapVertexAttrib1fAPPLE;
    long glMapVertexAttrib2dAPPLE;
    long glMapVertexAttrib2fAPPLE;
    long glGetTextureHandleARB;
    long glGetTextureSamplerHandleARB;
    long glMakeTextureHandleResidentARB;
    long glMakeTextureHandleNonResidentARB;
    long glGetImageHandleARB;
    long glMakeImageHandleResidentARB;
    long glMakeImageHandleNonResidentARB;
    long glUniformHandleui64ARB;
    long glUniformHandleui64vARB;
    long glProgramUniformHandleui64ARB;
    long glProgramUniformHandleui64vARB;
    long glIsTextureHandleResidentARB;
    long glIsImageHandleResidentARB;
    long glVertexAttribL1ui64ARB;
    long glVertexAttribL1ui64vARB;
    long glGetVertexAttribLui64vARB;
    long glBindBufferARB;
    long glDeleteBuffersARB;
    long glGenBuffersARB;
    long glIsBufferARB;
    long glBufferDataARB;
    long glBufferSubDataARB;
    long glGetBufferSubDataARB;
    long glMapBufferARB;
    long glUnmapBufferARB;
    long glGetBufferParameterivARB;
    long glGetBufferPointervARB;
    long glNamedBufferStorageEXT;
    long glCreateSyncFromCLeventARB;
    long glClearNamedBufferDataEXT;
    long glClearNamedBufferSubDataEXT;
    long glClampColorARB;
    long glDispatchComputeGroupSizeARB;
    long glDebugMessageControlARB;
    long glDebugMessageInsertARB;
    long glDebugMessageCallbackARB;
    long glGetDebugMessageLogARB;
    long glDrawBuffersARB;
    long glBlendEquationiARB;
    long glBlendEquationSeparateiARB;
    long glBlendFunciARB;
    long glBlendFuncSeparateiARB;
    long glDrawArraysInstancedARB;
    long glDrawElementsInstancedARB;
    long glNamedFramebufferParameteriEXT;
    long glGetNamedFramebufferParameterivEXT;
    long glProgramParameteriARB;
    long glFramebufferTextureARB;
    long glFramebufferTextureLayerARB;
    long glFramebufferTextureFaceARB;
    long glProgramUniform1dEXT;
    long glProgramUniform2dEXT;
    long glProgramUniform3dEXT;
    long glProgramUniform4dEXT;
    long glProgramUniform1dvEXT;
    long glProgramUniform2dvEXT;
    long glProgramUniform3dvEXT;
    long glProgramUniform4dvEXT;
    long glProgramUniformMatrix2dvEXT;
    long glProgramUniformMatrix3dvEXT;
    long glProgramUniformMatrix4dvEXT;
    long glProgramUniformMatrix2x3dvEXT;
    long glProgramUniformMatrix2x4dvEXT;
    long glProgramUniformMatrix3x2dvEXT;
    long glProgramUniformMatrix3x4dvEXT;
    long glProgramUniformMatrix4x2dvEXT;
    long glProgramUniformMatrix4x3dvEXT;
    long glColorTable;
    long glColorSubTable;
    long glColorTableParameteriv;
    long glColorTableParameterfv;
    long glCopyColorSubTable;
    long glCopyColorTable;
    long glGetColorTable;
    long glGetColorTableParameteriv;
    long glGetColorTableParameterfv;
    long glHistogram;
    long glResetHistogram;
    long glGetHistogram;
    long glGetHistogramParameterfv;
    long glGetHistogramParameteriv;
    long glMinmax;
    long glResetMinmax;
    long glGetMinmax;
    long glGetMinmaxParameterfv;
    long glGetMinmaxParameteriv;
    long glConvolutionFilter1D;
    long glConvolutionFilter2D;
    long glConvolutionParameterf;
    long glConvolutionParameterfv;
    long glConvolutionParameteri;
    long glConvolutionParameteriv;
    long glCopyConvolutionFilter1D;
    long glCopyConvolutionFilter2D;
    long glGetConvolutionFilter;
    long glGetConvolutionParameterfv;
    long glGetConvolutionParameteriv;
    long glSeparableFilter2D;
    long glGetSeparableFilter;
    long glMultiDrawArraysIndirectCountARB;
    long glMultiDrawElementsIndirectCountARB;
    long glVertexAttribDivisorARB;
    long glCurrentPaletteMatrixARB;
    long glMatrixIndexPointerARB;
    long glMatrixIndexubvARB;
    long glMatrixIndexusvARB;
    long glMatrixIndexuivARB;
    long glSampleCoverageARB;
    long glClientActiveTextureARB;
    long glActiveTextureARB;
    long glMultiTexCoord1fARB;
    long glMultiTexCoord1dARB;
    long glMultiTexCoord1iARB;
    long glMultiTexCoord1sARB;
    long glMultiTexCoord2fARB;
    long glMultiTexCoord2dARB;
    long glMultiTexCoord2iARB;
    long glMultiTexCoord2sARB;
    long glMultiTexCoord3fARB;
    long glMultiTexCoord3dARB;
    long glMultiTexCoord3iARB;
    long glMultiTexCoord3sARB;
    long glMultiTexCoord4fARB;
    long glMultiTexCoord4dARB;
    long glMultiTexCoord4iARB;
    long glMultiTexCoord4sARB;
    long glGenQueriesARB;
    long glDeleteQueriesARB;
    long glIsQueryARB;
    long glBeginQueryARB;
    long glEndQueryARB;
    long glGetQueryivARB;
    long glGetQueryObjectivARB;
    long glGetQueryObjectuivARB;
    long glPointParameterfARB;
    long glPointParameterfvARB;
    long glProgramStringARB;
    long glBindProgramARB;
    long glDeleteProgramsARB;
    long glGenProgramsARB;
    long glProgramEnvParameter4fARB;
    long glProgramEnvParameter4dARB;
    long glProgramEnvParameter4fvARB;
    long glProgramEnvParameter4dvARB;
    long glProgramLocalParameter4fARB;
    long glProgramLocalParameter4dARB;
    long glProgramLocalParameter4fvARB;
    long glProgramLocalParameter4dvARB;
    long glGetProgramEnvParameterfvARB;
    long glGetProgramEnvParameterdvARB;
    long glGetProgramLocalParameterfvARB;
    long glGetProgramLocalParameterdvARB;
    long glGetProgramivARB;
    long glGetProgramStringARB;
    long glIsProgramARB;
    long glGetGraphicsResetStatusARB;
    long glGetnMapdvARB;
    long glGetnMapfvARB;
    long glGetnMapivARB;
    long glGetnPixelMapfvARB;
    long glGetnPixelMapuivARB;
    long glGetnPixelMapusvARB;
    long glGetnPolygonStippleARB;
    long glGetnTexImageARB;
    long glReadnPixelsARB;
    long glGetnColorTableARB;
    long glGetnConvolutionFilterARB;
    long glGetnSeparableFilterARB;
    long glGetnHistogramARB;
    long glGetnMinmaxARB;
    long glGetnCompressedTexImageARB;
    long glGetnUniformfvARB;
    long glGetnUniformivARB;
    long glGetnUniformuivARB;
    long glGetnUniformdvARB;
    long glMinSampleShadingARB;
    long glDeleteObjectARB;
    long glGetHandleARB;
    long glDetachObjectARB;
    long glCreateShaderObjectARB;
    long glShaderSourceARB;
    long glCompileShaderARB;
    long glCreateProgramObjectARB;
    long glAttachObjectARB;
    long glLinkProgramARB;
    long glUseProgramObjectARB;
    long glValidateProgramARB;
    long glUniform1fARB;
    long glUniform2fARB;
    long glUniform3fARB;
    long glUniform4fARB;
    long glUniform1iARB;
    long glUniform2iARB;
    long glUniform3iARB;
    long glUniform4iARB;
    long glUniform1fvARB;
    long glUniform2fvARB;
    long glUniform3fvARB;
    long glUniform4fvARB;
    long glUniform1ivARB;
    long glUniform2ivARB;
    long glUniform3ivARB;
    long glUniform4ivARB;
    long glUniformMatrix2fvARB;
    long glUniformMatrix3fvARB;
    long glUniformMatrix4fvARB;
    long glGetObjectParameterfvARB;
    long glGetObjectParameterivARB;
    long glGetInfoLogARB;
    long glGetAttachedObjectsARB;
    long glGetUniformLocationARB;
    long glGetActiveUniformARB;
    long glGetUniformfvARB;
    long glGetUniformivARB;
    long glGetShaderSourceARB;
    long glNamedStringARB;
    long glDeleteNamedStringARB;
    long glCompileShaderIncludeARB;
    long glIsNamedStringARB;
    long glGetNamedStringARB;
    long glGetNamedStringivARB;
    long glBufferPageCommitmentARB;
    long glTexPageCommitmentARB;
    long glTexturePageCommitmentEXT;
    long glTexBufferARB;
    long glTextureBufferRangeEXT;
    long glCompressedTexImage1DARB;
    long glCompressedTexImage2DARB;
    long glCompressedTexImage3DARB;
    long glCompressedTexSubImage1DARB;
    long glCompressedTexSubImage2DARB;
    long glCompressedTexSubImage3DARB;
    long glGetCompressedTexImageARB;
    long glTextureStorage1DEXT;
    long glTextureStorage2DEXT;
    long glTextureStorage3DEXT;
    long glTextureStorage2DMultisampleEXT;
    long glTextureStorage3DMultisampleEXT;
    long glLoadTransposeMatrixfARB;
    long glMultTransposeMatrixfARB;
    long glVertexArrayVertexAttribLOffsetEXT;
    long glWeightbvARB;
    long glWeightsvARB;
    long glWeightivARB;
    long glWeightfvARB;
    long glWeightdvARB;
    long glWeightubvARB;
    long glWeightusvARB;
    long glWeightuivARB;
    long glWeightPointerARB;
    long glVertexBlendARB;
    long glVertexAttrib1sARB;
    long glVertexAttrib1fARB;
    long glVertexAttrib1dARB;
    long glVertexAttrib2sARB;
    long glVertexAttrib2fARB;
    long glVertexAttrib2dARB;
    long glVertexAttrib3sARB;
    long glVertexAttrib3fARB;
    long glVertexAttrib3dARB;
    long glVertexAttrib4sARB;
    long glVertexAttrib4fARB;
    long glVertexAttrib4dARB;
    long glVertexAttrib4NubARB;
    long glVertexAttribPointerARB;
    long glEnableVertexAttribArrayARB;
    long glDisableVertexAttribArrayARB;
    long glBindAttribLocationARB;
    long glGetActiveAttribARB;
    long glGetAttribLocationARB;
    long glGetVertexAttribfvARB;
    long glGetVertexAttribdvARB;
    long glGetVertexAttribivARB;
    long glGetVertexAttribPointervARB;
    long glWindowPos2fARB;
    long glWindowPos2dARB;
    long glWindowPos2iARB;
    long glWindowPos2sARB;
    long glWindowPos3fARB;
    long glWindowPos3dARB;
    long glWindowPos3iARB;
    long glWindowPos3sARB;
    long glDrawBuffersATI;
    long glElementPointerATI;
    long glDrawElementArrayATI;
    long glDrawRangeElementArrayATI;
    long glTexBumpParameterfvATI;
    long glTexBumpParameterivATI;
    long glGetTexBumpParameterfvATI;
    long glGetTexBumpParameterivATI;
    long glGenFragmentShadersATI;
    long glBindFragmentShaderATI;
    long glDeleteFragmentShaderATI;
    long glBeginFragmentShaderATI;
    long glEndFragmentShaderATI;
    long glPassTexCoordATI;
    long glSampleMapATI;
    long glColorFragmentOp1ATI;
    long glColorFragmentOp2ATI;
    long glColorFragmentOp3ATI;
    long glAlphaFragmentOp1ATI;
    long glAlphaFragmentOp2ATI;
    long glAlphaFragmentOp3ATI;
    long glSetFragmentShaderConstantATI;
    long glMapObjectBufferATI;
    long glUnmapObjectBufferATI;
    long glPNTrianglesfATI;
    long glPNTrianglesiATI;
    long glStencilOpSeparateATI;
    long glStencilFuncSeparateATI;
    long glNewObjectBufferATI;
    long glIsObjectBufferATI;
    long glUpdateObjectBufferATI;
    long glGetObjectBufferfvATI;
    long glGetObjectBufferivATI;
    long glFreeObjectBufferATI;
    long glArrayObjectATI;
    long glGetArrayObjectfvATI;
    long glGetArrayObjectivATI;
    long glVariantArrayObjectATI;
    long glGetVariantArrayObjectfvATI;
    long glGetVariantArrayObjectivATI;
    long glVertexAttribArrayObjectATI;
    long glGetVertexAttribArrayObjectfvATI;
    long glGetVertexAttribArrayObjectivATI;
    long glVertexStream2fATI;
    long glVertexStream2dATI;
    long glVertexStream2iATI;
    long glVertexStream2sATI;
    long glVertexStream3fATI;
    long glVertexStream3dATI;
    long glVertexStream3iATI;
    long glVertexStream3sATI;
    long glVertexStream4fATI;
    long glVertexStream4dATI;
    long glVertexStream4iATI;
    long glVertexStream4sATI;
    long glNormalStream3bATI;
    long glNormalStream3fATI;
    long glNormalStream3dATI;
    long glNormalStream3iATI;
    long glNormalStream3sATI;
    long glClientActiveVertexStreamATI;
    long glVertexBlendEnvfATI;
    long glVertexBlendEnviATI;
    long glUniformBufferEXT;
    long glGetUniformBufferSizeEXT;
    long glGetUniformOffsetEXT;
    long glBlendColorEXT;
    long glBlendEquationSeparateEXT;
    long glBlendFuncSeparateEXT;
    long glBlendEquationEXT;
    long glLockArraysEXT;
    long glUnlockArraysEXT;
    long glDepthBoundsEXT;
    long glClientAttribDefaultEXT;
    long glPushClientAttribDefaultEXT;
    long glMatrixLoadfEXT;
    long glMatrixLoaddEXT;
    long glMatrixMultfEXT;
    long glMatrixMultdEXT;
    long glMatrixLoadIdentityEXT;
    long glMatrixRotatefEXT;
    long glMatrixRotatedEXT;
    long glMatrixScalefEXT;
    long glMatrixScaledEXT;
    long glMatrixTranslatefEXT;
    long glMatrixTranslatedEXT;
    long glMatrixOrthoEXT;
    long glMatrixFrustumEXT;
    long glMatrixPushEXT;
    long glMatrixPopEXT;
    long glTextureParameteriEXT;
    long glTextureParameterivEXT;
    long glTextureParameterfEXT;
    long glTextureParameterfvEXT;
    long glTextureImage1DEXT;
    long glTextureImage2DEXT;
    long glTextureSubImage1DEXT;
    long glTextureSubImage2DEXT;
    long glCopyTextureImage1DEXT;
    long glCopyTextureImage2DEXT;
    long glCopyTextureSubImage1DEXT;
    long glCopyTextureSubImage2DEXT;
    long glGetTextureImageEXT;
    long glGetTextureParameterfvEXT;
    long glGetTextureParameterivEXT;
    long glGetTextureLevelParameterfvEXT;
    long glGetTextureLevelParameterivEXT;
    long glTextureImage3DEXT;
    long glTextureSubImage3DEXT;
    long glCopyTextureSubImage3DEXT;
    long glBindMultiTextureEXT;
    long glMultiTexCoordPointerEXT;
    long glMultiTexEnvfEXT;
    long glMultiTexEnvfvEXT;
    long glMultiTexEnviEXT;
    long glMultiTexEnvivEXT;
    long glMultiTexGendEXT;
    long glMultiTexGendvEXT;
    long glMultiTexGenfEXT;
    long glMultiTexGenfvEXT;
    long glMultiTexGeniEXT;
    long glMultiTexGenivEXT;
    long glGetMultiTexEnvfvEXT;
    long glGetMultiTexEnvivEXT;
    long glGetMultiTexGendvEXT;
    long glGetMultiTexGenfvEXT;
    long glGetMultiTexGenivEXT;
    long glMultiTexParameteriEXT;
    long glMultiTexParameterivEXT;
    long glMultiTexParameterfEXT;
    long glMultiTexParameterfvEXT;
    long glMultiTexImage1DEXT;
    long glMultiTexImage2DEXT;
    long glMultiTexSubImage1DEXT;
    long glMultiTexSubImage2DEXT;
    long glCopyMultiTexImage1DEXT;
    long glCopyMultiTexImage2DEXT;
    long glCopyMultiTexSubImage1DEXT;
    long glCopyMultiTexSubImage2DEXT;
    long glGetMultiTexImageEXT;
    long glGetMultiTexParameterfvEXT;
    long glGetMultiTexParameterivEXT;
    long glGetMultiTexLevelParameterfvEXT;
    long glGetMultiTexLevelParameterivEXT;
    long glMultiTexImage3DEXT;
    long glMultiTexSubImage3DEXT;
    long glCopyMultiTexSubImage3DEXT;
    long glEnableClientStateIndexedEXT;
    long glDisableClientStateIndexedEXT;
    long glEnableClientStateiEXT;
    long glDisableClientStateiEXT;
    long glGetFloatIndexedvEXT;
    long glGetDoubleIndexedvEXT;
    long glGetPointerIndexedvEXT;
    long glGetFloati_vEXT;
    long glGetDoublei_vEXT;
    long glGetPointeri_vEXT;
    long glNamedProgramStringEXT;
    long glNamedProgramLocalParameter4dEXT;
    long glNamedProgramLocalParameter4dvEXT;
    long glNamedProgramLocalParameter4fEXT;
    long glNamedProgramLocalParameter4fvEXT;
    long glGetNamedProgramLocalParameterdvEXT;
    long glGetNamedProgramLocalParameterfvEXT;
    long glGetNamedProgramivEXT;
    long glGetNamedProgramStringEXT;
    long glCompressedTextureImage3DEXT;
    long glCompressedTextureImage2DEXT;
    long glCompressedTextureImage1DEXT;
    long glCompressedTextureSubImage3DEXT;
    long glCompressedTextureSubImage2DEXT;
    long glCompressedTextureSubImage1DEXT;
    long glGetCompressedTextureImageEXT;
    long glCompressedMultiTexImage3DEXT;
    long glCompressedMultiTexImage2DEXT;
    long glCompressedMultiTexImage1DEXT;
    long glCompressedMultiTexSubImage3DEXT;
    long glCompressedMultiTexSubImage2DEXT;
    long glCompressedMultiTexSubImage1DEXT;
    long glGetCompressedMultiTexImageEXT;
    long glMatrixLoadTransposefEXT;
    long glMatrixLoadTransposedEXT;
    long glMatrixMultTransposefEXT;
    long glMatrixMultTransposedEXT;
    long glNamedBufferDataEXT;
    long glNamedBufferSubDataEXT;
    long glMapNamedBufferEXT;
    long glUnmapNamedBufferEXT;
    long glGetNamedBufferParameterivEXT;
    long glGetNamedBufferPointervEXT;
    long glGetNamedBufferSubDataEXT;
    long glProgramUniform1fEXT;
    long glProgramUniform2fEXT;
    long glProgramUniform3fEXT;
    long glProgramUniform4fEXT;
    long glProgramUniform1iEXT;
    long glProgramUniform2iEXT;
    long glProgramUniform3iEXT;
    long glProgramUniform4iEXT;
    long glProgramUniform1fvEXT;
    long glProgramUniform2fvEXT;
    long glProgramUniform3fvEXT;
    long glProgramUniform4fvEXT;
    long glProgramUniform1ivEXT;
    long glProgramUniform2ivEXT;
    long glProgramUniform3ivEXT;
    long glProgramUniform4ivEXT;
    long glProgramUniformMatrix2fvEXT;
    long glProgramUniformMatrix3fvEXT;
    long glProgramUniformMatrix4fvEXT;
    long glProgramUniformMatrix2x3fvEXT;
    long glProgramUniformMatrix3x2fvEXT;
    long glProgramUniformMatrix2x4fvEXT;
    long glProgramUniformMatrix4x2fvEXT;
    long glProgramUniformMatrix3x4fvEXT;
    long glProgramUniformMatrix4x3fvEXT;
    long glTextureBufferEXT;
    long glMultiTexBufferEXT;
    long glTextureParameterIivEXT;
    long glTextureParameterIuivEXT;
    long glGetTextureParameterIivEXT;
    long glGetTextureParameterIuivEXT;
    long glMultiTexParameterIivEXT;
    long glMultiTexParameterIuivEXT;
    long glGetMultiTexParameterIivEXT;
    long glGetMultiTexParameterIuivEXT;
    long glProgramUniform1uiEXT;
    long glProgramUniform2uiEXT;
    long glProgramUniform3uiEXT;
    long glProgramUniform4uiEXT;
    long glProgramUniform1uivEXT;
    long glProgramUniform2uivEXT;
    long glProgramUniform3uivEXT;
    long glProgramUniform4uivEXT;
    long glNamedProgramLocalParameters4fvEXT;
    long glNamedProgramLocalParameterI4iEXT;
    long glNamedProgramLocalParameterI4ivEXT;
    long glNamedProgramLocalParametersI4ivEXT;
    long glNamedProgramLocalParameterI4uiEXT;
    long glNamedProgramLocalParameterI4uivEXT;
    long glNamedProgramLocalParametersI4uivEXT;
    long glGetNamedProgramLocalParameterIivEXT;
    long glGetNamedProgramLocalParameterIuivEXT;
    long glNamedRenderbufferStorageEXT;
    long glGetNamedRenderbufferParameterivEXT;
    long glNamedRenderbufferStorageMultisampleEXT;
    long glNamedRenderbufferStorageMultisampleCoverageEXT;
    long glCheckNamedFramebufferStatusEXT;
    long glNamedFramebufferTexture1DEXT;
    long glNamedFramebufferTexture2DEXT;
    long glNamedFramebufferTexture3DEXT;
    long glNamedFramebufferRenderbufferEXT;
    long glGetNamedFramebufferAttachmentParameterivEXT;
    long glGenerateTextureMipmapEXT;
    long glGenerateMultiTexMipmapEXT;
    long glFramebufferDrawBufferEXT;
    long glFramebufferDrawBuffersEXT;
    long glFramebufferReadBufferEXT;
    long glGetFramebufferParameterivEXT;
    long glNamedCopyBufferSubDataEXT;
    long glNamedFramebufferTextureEXT;
    long glNamedFramebufferTextureLayerEXT;
    long glNamedFramebufferTextureFaceEXT;
    long glTextureRenderbufferEXT;
    long glMultiTexRenderbufferEXT;
    long glVertexArrayVertexOffsetEXT;
    long glVertexArrayColorOffsetEXT;
    long glVertexArrayEdgeFlagOffsetEXT;
    long glVertexArrayIndexOffsetEXT;
    long glVertexArrayNormalOffsetEXT;
    long glVertexArrayTexCoordOffsetEXT;
    long glVertexArrayMultiTexCoordOffsetEXT;
    long glVertexArrayFogCoordOffsetEXT;
    long glVertexArraySecondaryColorOffsetEXT;
    long glVertexArrayVertexAttribOffsetEXT;
    long glVertexArrayVertexAttribIOffsetEXT;
    long glEnableVertexArrayEXT;
    long glDisableVertexArrayEXT;
    long glEnableVertexArrayAttribEXT;
    long glDisableVertexArrayAttribEXT;
    long glGetVertexArrayIntegervEXT;
    long glGetVertexArrayPointervEXT;
    long glGetVertexArrayIntegeri_vEXT;
    long glGetVertexArrayPointeri_vEXT;
    long glMapNamedBufferRangeEXT;
    long glFlushMappedNamedBufferRangeEXT;
    long glColorMaskIndexedEXT;
    long glGetBooleanIndexedvEXT;
    long glGetIntegerIndexedvEXT;
    long glEnableIndexedEXT;
    long glDisableIndexedEXT;
    long glIsEnabledIndexedEXT;
    long glDrawArraysInstancedEXT;
    long glDrawElementsInstancedEXT;
    long glDrawRangeElementsEXT;
    long glFogCoordfEXT;
    long glFogCoorddEXT;
    long glFogCoordPointerEXT;
    long glBlitFramebufferEXT;
    long glRenderbufferStorageMultisampleEXT;
    long glIsRenderbufferEXT;
    long glBindRenderbufferEXT;
    long glDeleteRenderbuffersEXT;
    long glGenRenderbuffersEXT;
    long glRenderbufferStorageEXT;
    long glGetRenderbufferParameterivEXT;
    long glIsFramebufferEXT;
    long glBindFramebufferEXT;
    long glDeleteFramebuffersEXT;
    long glGenFramebuffersEXT;
    long glCheckFramebufferStatusEXT;
    long glFramebufferTexture1DEXT;
    long glFramebufferTexture2DEXT;
    long glFramebufferTexture3DEXT;
    long glFramebufferRenderbufferEXT;
    long glGetFramebufferAttachmentParameterivEXT;
    long glGenerateMipmapEXT;
    long glProgramParameteriEXT;
    long glFramebufferTextureEXT;
    long glFramebufferTextureLayerEXT;
    long glFramebufferTextureFaceEXT;
    long glProgramEnvParameters4fvEXT;
    long glProgramLocalParameters4fvEXT;
    long glVertexAttribI1iEXT;
    long glVertexAttribI2iEXT;
    long glVertexAttribI3iEXT;
    long glVertexAttribI4iEXT;
    long glVertexAttribI1uiEXT;
    long glVertexAttribI2uiEXT;
    long glVertexAttribI3uiEXT;
    long glVertexAttribI4uiEXT;
    long glVertexAttribI1ivEXT;
    long glVertexAttribI2ivEXT;
    long glVertexAttribI3ivEXT;
    long glVertexAttribI4ivEXT;
    long glVertexAttribI1uivEXT;
    long glVertexAttribI2uivEXT;
    long glVertexAttribI3uivEXT;
    long glVertexAttribI4uivEXT;
    long glVertexAttribI4bvEXT;
    long glVertexAttribI4svEXT;
    long glVertexAttribI4ubvEXT;
    long glVertexAttribI4usvEXT;
    long glVertexAttribIPointerEXT;
    long glGetVertexAttribIivEXT;
    long glGetVertexAttribIuivEXT;
    long glUniform1uiEXT;
    long glUniform2uiEXT;
    long glUniform3uiEXT;
    long glUniform4uiEXT;
    long glUniform1uivEXT;
    long glUniform2uivEXT;
    long glUniform3uivEXT;
    long glUniform4uivEXT;
    long glGetUniformuivEXT;
    long glBindFragDataLocationEXT;
    long glGetFragDataLocationEXT;
    long glMultiDrawArraysEXT;
    long glColorTableEXT;
    long glColorSubTableEXT;
    long glGetColorTableEXT;
    long glGetColorTableParameterivEXT;
    long glGetColorTableParameterfvEXT;
    long glPointParameterfEXT;
    long glPointParameterfvEXT;
    long glProvokingVertexEXT;
    long glSecondaryColor3bEXT;
    long glSecondaryColor3fEXT;
    long glSecondaryColor3dEXT;
    long glSecondaryColor3ubEXT;
    long glSecondaryColorPointerEXT;
    long glUseShaderProgramEXT;
    long glActiveProgramEXT;
    long glCreateShaderProgramEXT;
    long glBindImageTextureEXT;
    long glMemoryBarrierEXT;
    long glStencilClearTagEXT;
    long glActiveStencilFaceEXT;
    long glTexBufferEXT;
    long glClearColorIiEXT;
    long glClearColorIuiEXT;
    long glTexParameterIivEXT;
    long glTexParameterIuivEXT;
    long glGetTexParameterIivEXT;
    long glGetTexParameterIuivEXT;
    long glGetQueryObjecti64vEXT;
    long glGetQueryObjectui64vEXT;
    long glBindBufferRangeEXT;
    long glBindBufferOffsetEXT;
    long glBindBufferBaseEXT;
    long glBeginTransformFeedbackEXT;
    long glEndTransformFeedbackEXT;
    long glTransformFeedbackVaryingsEXT;
    long glGetTransformFeedbackVaryingEXT;
    long glVertexAttribL1dEXT;
    long glVertexAttribL2dEXT;
    long glVertexAttribL3dEXT;
    long glVertexAttribL4dEXT;
    long glVertexAttribL1dvEXT;
    long glVertexAttribL2dvEXT;
    long glVertexAttribL3dvEXT;
    long glVertexAttribL4dvEXT;
    long glVertexAttribLPointerEXT;
    long glGetVertexAttribLdvEXT;
    long glBeginVertexShaderEXT;
    long glEndVertexShaderEXT;
    long glBindVertexShaderEXT;
    long glGenVertexShadersEXT;
    long glDeleteVertexShaderEXT;
    long glShaderOp1EXT;
    long glShaderOp2EXT;
    long glShaderOp3EXT;
    long glSwizzleEXT;
    long glWriteMaskEXT;
    long glInsertComponentEXT;
    long glExtractComponentEXT;
    long glGenSymbolsEXT;
    long glSetInvariantEXT;
    long glSetLocalConstantEXT;
    long glVariantbvEXT;
    long glVariantsvEXT;
    long glVariantivEXT;
    long glVariantfvEXT;
    long glVariantdvEXT;
    long glVariantubvEXT;
    long glVariantusvEXT;
    long glVariantuivEXT;
    long glVariantPointerEXT;
    long glEnableVariantClientStateEXT;
    long glDisableVariantClientStateEXT;
    long glBindLightParameterEXT;
    long glBindMaterialParameterEXT;
    long glBindTexGenParameterEXT;
    long glBindTextureUnitParameterEXT;
    long glBindParameterEXT;
    long glIsVariantEnabledEXT;
    long glGetVariantBooleanvEXT;
    long glGetVariantIntegervEXT;
    long glGetVariantFloatvEXT;
    long glGetVariantPointervEXT;
    long glGetInvariantBooleanvEXT;
    long glGetInvariantIntegervEXT;
    long glGetInvariantFloatvEXT;
    long glGetLocalConstantBooleanvEXT;
    long glGetLocalConstantIntegervEXT;
    long glGetLocalConstantFloatvEXT;
    long glVertexWeightfEXT;
    long glVertexWeightPointerEXT;
    long glAccum;
    long glAlphaFunc;
    long glClearColor;
    long glClearAccum;
    long glClear;
    long glCallLists;
    long glCallList;
    long glBlendFunc;
    long glBitmap;
    long glBindTexture;
    long glPrioritizeTextures;
    long glAreTexturesResident;
    long glBegin;
    long glEnd;
    long glArrayElement;
    long glClearDepth;
    long glDeleteLists;
    long glDeleteTextures;
    long glCullFace;
    long glCopyTexSubImage2D;
    long glCopyTexSubImage1D;
    long glCopyTexImage2D;
    long glCopyTexImage1D;
    long glCopyPixels;
    long glColorPointer;
    long glColorMaterial;
    long glColorMask;
    long glColor3b;
    long glColor3f;
    long glColor3d;
    long glColor3ub;
    long glColor4b;
    long glColor4f;
    long glColor4d;
    long glColor4ub;
    long glClipPlane;
    long glClearStencil;
    long glEvalPoint1;
    long glEvalPoint2;
    long glEvalMesh1;
    long glEvalMesh2;
    long glEvalCoord1f;
    long glEvalCoord1d;
    long glEvalCoord2f;
    long glEvalCoord2d;
    long glEnableClientState;
    long glDisableClientState;
    long glEnable;
    long glDisable;
    long glEdgeFlagPointer;
    long glEdgeFlag;
    long glDrawPixels;
    long glDrawElements;
    long glDrawBuffer;
    long glDrawArrays;
    long glDepthRange;
    long glDepthMask;
    long glDepthFunc;
    long glFeedbackBuffer;
    long glGetPixelMapfv;
    long glGetPixelMapuiv;
    long glGetPixelMapusv;
    long glGetMaterialfv;
    long glGetMaterialiv;
    long glGetMapfv;
    long glGetMapdv;
    long glGetMapiv;
    long glGetLightfv;
    long glGetLightiv;
    long glGetError;
    long glGetClipPlane;
    long glGetBooleanv;
    long glGetDoublev;
    long glGetFloatv;
    long glGetIntegerv;
    long glGenTextures;
    long glGenLists;
    long glFrustum;
    long glFrontFace;
    long glFogf;
    long glFogi;
    long glFogfv;
    long glFogiv;
    long glFlush;
    long glFinish;
    long glGetPointerv;
    long glIsEnabled;
    long glInterleavedArrays;
    long glInitNames;
    long glHint;
    long glGetTexParameterfv;
    long glGetTexParameteriv;
    long glGetTexLevelParameterfv;
    long glGetTexLevelParameteriv;
    long glGetTexImage;
    long glGetTexGeniv;
    long glGetTexGenfv;
    long glGetTexGendv;
    long glGetTexEnviv;
    long glGetTexEnvfv;
    long glGetString;
    long glGetPolygonStipple;
    long glIsList;
    long glMaterialf;
    long glMateriali;
    long glMaterialfv;
    long glMaterialiv;
    long glMapGrid1f;
    long glMapGrid1d;
    long glMapGrid2f;
    long glMapGrid2d;
    long glMap2f;
    long glMap2d;
    long glMap1f;
    long glMap1d;
    long glLogicOp;
    long glLoadName;
    long glLoadMatrixf;
    long glLoadMatrixd;
    long glLoadIdentity;
    long glListBase;
    long glLineWidth;
    long glLineStipple;
    long glLightModelf;
    long glLightModeli;
    long glLightModelfv;
    long glLightModeliv;
    long glLightf;
    long glLighti;
    long glLightfv;
    long glLightiv;
    long glIsTexture;
    long glMatrixMode;
    long glPolygonStipple;
    long glPolygonOffset;
    long glPolygonMode;
    long glPointSize;
    long glPixelZoom;
    long glPixelTransferf;
    long glPixelTransferi;
    long glPixelStoref;
    long glPixelStorei;
    long glPixelMapfv;
    long glPixelMapuiv;
    long glPixelMapusv;
    long glPassThrough;
    long glOrtho;
    long glNormalPointer;
    long glNormal3b;
    long glNormal3f;
    long glNormal3d;
    long glNormal3i;
    long glNewList;
    long glEndList;
    long glMultMatrixf;
    long glMultMatrixd;
    long glShadeModel;
    long glSelectBuffer;
    long glScissor;
    long glScalef;
    long glScaled;
    long glRotatef;
    long glRotated;
    long glRenderMode;
    long glRectf;
    long glRectd;
    long glRecti;
    long glReadPixels;
    long glReadBuffer;
    long glRasterPos2f;
    long glRasterPos2d;
    long glRasterPos2i;
    long glRasterPos3f;
    long glRasterPos3d;
    long glRasterPos3i;
    long glRasterPos4f;
    long glRasterPos4d;
    long glRasterPos4i;
    long glPushName;
    long glPopName;
    long glPushMatrix;
    long glPopMatrix;
    long glPushClientAttrib;
    long glPopClientAttrib;
    long glPushAttrib;
    long glPopAttrib;
    long glStencilFunc;
    long glVertexPointer;
    long glVertex2f;
    long glVertex2d;
    long glVertex2i;
    long glVertex3f;
    long glVertex3d;
    long glVertex3i;
    long glVertex4f;
    long glVertex4d;
    long glVertex4i;
    long glTranslatef;
    long glTranslated;
    long glTexImage1D;
    long glTexImage2D;
    long glTexSubImage1D;
    long glTexSubImage2D;
    long glTexParameterf;
    long glTexParameteri;
    long glTexParameterfv;
    long glTexParameteriv;
    long glTexGenf;
    long glTexGend;
    long glTexGenfv;
    long glTexGendv;
    long glTexGeni;
    long glTexGeniv;
    long glTexEnvf;
    long glTexEnvi;
    long glTexEnvfv;
    long glTexEnviv;
    long glTexCoordPointer;
    long glTexCoord1f;
    long glTexCoord1d;
    long glTexCoord2f;
    long glTexCoord2d;
    long glTexCoord3f;
    long glTexCoord3d;
    long glTexCoord4f;
    long glTexCoord4d;
    long glStencilOp;
    long glStencilMask;
    long glViewport;
    long glDrawRangeElements;
    long glTexImage3D;
    long glTexSubImage3D;
    long glCopyTexSubImage3D;
    long glActiveTexture;
    long glClientActiveTexture;
    long glCompressedTexImage1D;
    long glCompressedTexImage2D;
    long glCompressedTexImage3D;
    long glCompressedTexSubImage1D;
    long glCompressedTexSubImage2D;
    long glCompressedTexSubImage3D;
    long glGetCompressedTexImage;
    long glMultiTexCoord1f;
    long glMultiTexCoord1d;
    long glMultiTexCoord2f;
    long glMultiTexCoord2d;
    long glMultiTexCoord3f;
    long glMultiTexCoord3d;
    long glMultiTexCoord4f;
    long glMultiTexCoord4d;
    long glLoadTransposeMatrixf;
    long glLoadTransposeMatrixd;
    long glMultTransposeMatrixf;
    long glMultTransposeMatrixd;
    long glSampleCoverage;
    long glBlendEquation;
    long glBlendColor;
    long glFogCoordf;
    long glFogCoordd;
    long glFogCoordPointer;
    long glMultiDrawArrays;
    long glPointParameteri;
    long glPointParameterf;
    long glPointParameteriv;
    long glPointParameterfv;
    long glSecondaryColor3b;
    long glSecondaryColor3f;
    long glSecondaryColor3d;
    long glSecondaryColor3ub;
    long glSecondaryColorPointer;
    long glBlendFuncSeparate;
    long glWindowPos2f;
    long glWindowPos2d;
    long glWindowPos2i;
    long glWindowPos3f;
    long glWindowPos3d;
    long glWindowPos3i;
    long glBindBuffer;
    long glDeleteBuffers;
    long glGenBuffers;
    long glIsBuffer;
    long glBufferData;
    long glBufferSubData;
    long glGetBufferSubData;
    long glMapBuffer;
    long glUnmapBuffer;
    long glGetBufferParameteriv;
    long glGetBufferPointerv;
    long glGenQueries;
    long glDeleteQueries;
    long glIsQuery;
    long glBeginQuery;
    long glEndQuery;
    long glGetQueryiv;
    long glGetQueryObjectiv;
    long glGetQueryObjectuiv;
    long glShaderSource;
    long glCreateShader;
    long glIsShader;
    long glCompileShader;
    long glDeleteShader;
    long glCreateProgram;
    long glIsProgram;
    long glAttachShader;
    long glDetachShader;
    long glLinkProgram;
    long glUseProgram;
    long glValidateProgram;
    long glDeleteProgram;
    long glUniform1f;
    long glUniform2f;
    long glUniform3f;
    long glUniform4f;
    long glUniform1i;
    long glUniform2i;
    long glUniform3i;
    long glUniform4i;
    long glUniform1fv;
    long glUniform2fv;
    long glUniform3fv;
    long glUniform4fv;
    long glUniform1iv;
    long glUniform2iv;
    long glUniform3iv;
    long glUniform4iv;
    long glUniformMatrix2fv;
    long glUniformMatrix3fv;
    long glUniformMatrix4fv;
    long glGetShaderiv;
    long glGetProgramiv;
    long glGetShaderInfoLog;
    long glGetProgramInfoLog;
    long glGetAttachedShaders;
    long glGetUniformLocation;
    long glGetActiveUniform;
    long glGetUniformfv;
    long glGetUniformiv;
    long glGetShaderSource;
    long glVertexAttrib1s;
    long glVertexAttrib1f;
    long glVertexAttrib1d;
    long glVertexAttrib2s;
    long glVertexAttrib2f;
    long glVertexAttrib2d;
    long glVertexAttrib3s;
    long glVertexAttrib3f;
    long glVertexAttrib3d;
    long glVertexAttrib4s;
    long glVertexAttrib4f;
    long glVertexAttrib4d;
    long glVertexAttrib4Nub;
    long glVertexAttribPointer;
    long glEnableVertexAttribArray;
    long glDisableVertexAttribArray;
    long glGetVertexAttribfv;
    long glGetVertexAttribdv;
    long glGetVertexAttribiv;
    long glGetVertexAttribPointerv;
    long glBindAttribLocation;
    long glGetActiveAttrib;
    long glGetAttribLocation;
    long glDrawBuffers;
    long glStencilOpSeparate;
    long glStencilFuncSeparate;
    long glStencilMaskSeparate;
    long glBlendEquationSeparate;
    long glUniformMatrix2x3fv;
    long glUniformMatrix3x2fv;
    long glUniformMatrix2x4fv;
    long glUniformMatrix4x2fv;
    long glUniformMatrix3x4fv;
    long glUniformMatrix4x3fv;
    long glGetStringi;
    long glClearBufferfv;
    long glClearBufferiv;
    long glClearBufferuiv;
    long glClearBufferfi;
    long glVertexAttribI1i;
    long glVertexAttribI2i;
    long glVertexAttribI3i;
    long glVertexAttribI4i;
    long glVertexAttribI1ui;
    long glVertexAttribI2ui;
    long glVertexAttribI3ui;
    long glVertexAttribI4ui;
    long glVertexAttribI1iv;
    long glVertexAttribI2iv;
    long glVertexAttribI3iv;
    long glVertexAttribI4iv;
    long glVertexAttribI1uiv;
    long glVertexAttribI2uiv;
    long glVertexAttribI3uiv;
    long glVertexAttribI4uiv;
    long glVertexAttribI4bv;
    long glVertexAttribI4sv;
    long glVertexAttribI4ubv;
    long glVertexAttribI4usv;
    long glVertexAttribIPointer;
    long glGetVertexAttribIiv;
    long glGetVertexAttribIuiv;
    long glUniform1ui;
    long glUniform2ui;
    long glUniform3ui;
    long glUniform4ui;
    long glUniform1uiv;
    long glUniform2uiv;
    long glUniform3uiv;
    long glUniform4uiv;
    long glGetUniformuiv;
    long glBindFragDataLocation;
    long glGetFragDataLocation;
    long glBeginConditionalRender;
    long glEndConditionalRender;
    long glMapBufferRange;
    long glFlushMappedBufferRange;
    long glClampColor;
    long glIsRenderbuffer;
    long glBindRenderbuffer;
    long glDeleteRenderbuffers;
    long glGenRenderbuffers;
    long glRenderbufferStorage;
    long glGetRenderbufferParameteriv;
    long glIsFramebuffer;
    long glBindFramebuffer;
    long glDeleteFramebuffers;
    long glGenFramebuffers;
    long glCheckFramebufferStatus;
    long glFramebufferTexture1D;
    long glFramebufferTexture2D;
    long glFramebufferTexture3D;
    long glFramebufferRenderbuffer;
    long glGetFramebufferAttachmentParameteriv;
    long glGenerateMipmap;
    long glRenderbufferStorageMultisample;
    long glBlitFramebuffer;
    long glTexParameterIiv;
    long glTexParameterIuiv;
    long glGetTexParameterIiv;
    long glGetTexParameterIuiv;
    long glFramebufferTextureLayer;
    long glColorMaski;
    long glGetBooleani_v;
    long glGetIntegeri_v;
    long glEnablei;
    long glDisablei;
    long glIsEnabledi;
    long glBindBufferRange;
    long glBindBufferBase;
    long glBeginTransformFeedback;
    long glEndTransformFeedback;
    long glTransformFeedbackVaryings;
    long glGetTransformFeedbackVarying;
    long glBindVertexArray;
    long glDeleteVertexArrays;
    long glGenVertexArrays;
    long glIsVertexArray;
    long glDrawArraysInstanced;
    long glDrawElementsInstanced;
    long glCopyBufferSubData;
    long glPrimitiveRestartIndex;
    long glTexBuffer;
    long glGetUniformIndices;
    long glGetActiveUniformsiv;
    long glGetActiveUniformName;
    long glGetUniformBlockIndex;
    long glGetActiveUniformBlockiv;
    long glGetActiveUniformBlockName;
    long glUniformBlockBinding;
    long glGetBufferParameteri64v;
    long glDrawElementsBaseVertex;
    long glDrawRangeElementsBaseVertex;
    long glDrawElementsInstancedBaseVertex;
    long glProvokingVertex;
    long glTexImage2DMultisample;
    long glTexImage3DMultisample;
    long glGetMultisamplefv;
    long glSampleMaski;
    long glFramebufferTexture;
    long glFenceSync;
    long glIsSync;
    long glDeleteSync;
    long glClientWaitSync;
    long glWaitSync;
    long glGetInteger64v;
    long glGetInteger64i_v;
    long glGetSynciv;
    long glBindFragDataLocationIndexed;
    long glGetFragDataIndex;
    long glGenSamplers;
    long glDeleteSamplers;
    long glIsSampler;
    long glBindSampler;
    long glSamplerParameteri;
    long glSamplerParameterf;
    long glSamplerParameteriv;
    long glSamplerParameterfv;
    long glSamplerParameterIiv;
    long glSamplerParameterIuiv;
    long glGetSamplerParameteriv;
    long glGetSamplerParameterfv;
    long glGetSamplerParameterIiv;
    long glGetSamplerParameterIuiv;
    long glQueryCounter;
    long glGetQueryObjecti64v;
    long glGetQueryObjectui64v;
    long glVertexAttribDivisor;
    long glVertexP2ui;
    long glVertexP3ui;
    long glVertexP4ui;
    long glVertexP2uiv;
    long glVertexP3uiv;
    long glVertexP4uiv;
    long glTexCoordP1ui;
    long glTexCoordP2ui;
    long glTexCoordP3ui;
    long glTexCoordP4ui;
    long glTexCoordP1uiv;
    long glTexCoordP2uiv;
    long glTexCoordP3uiv;
    long glTexCoordP4uiv;
    long glMultiTexCoordP1ui;
    long glMultiTexCoordP2ui;
    long glMultiTexCoordP3ui;
    long glMultiTexCoordP4ui;
    long glMultiTexCoordP1uiv;
    long glMultiTexCoordP2uiv;
    long glMultiTexCoordP3uiv;
    long glMultiTexCoordP4uiv;
    long glNormalP3ui;
    long glNormalP3uiv;
    long glColorP3ui;
    long glColorP4ui;
    long glColorP3uiv;
    long glColorP4uiv;
    long glSecondaryColorP3ui;
    long glSecondaryColorP3uiv;
    long glVertexAttribP1ui;
    long glVertexAttribP2ui;
    long glVertexAttribP3ui;
    long glVertexAttribP4ui;
    long glVertexAttribP1uiv;
    long glVertexAttribP2uiv;
    long glVertexAttribP3uiv;
    long glVertexAttribP4uiv;
    long glBlendEquationi;
    long glBlendEquationSeparatei;
    long glBlendFunci;
    long glBlendFuncSeparatei;
    long glDrawArraysIndirect;
    long glDrawElementsIndirect;
    long glUniform1d;
    long glUniform2d;
    long glUniform3d;
    long glUniform4d;
    long glUniform1dv;
    long glUniform2dv;
    long glUniform3dv;
    long glUniform4dv;
    long glUniformMatrix2dv;
    long glUniformMatrix3dv;
    long glUniformMatrix4dv;
    long glUniformMatrix2x3dv;
    long glUniformMatrix2x4dv;
    long glUniformMatrix3x2dv;
    long glUniformMatrix3x4dv;
    long glUniformMatrix4x2dv;
    long glUniformMatrix4x3dv;
    long glGetUniformdv;
    long glMinSampleShading;
    long glGetSubroutineUniformLocation;
    long glGetSubroutineIndex;
    long glGetActiveSubroutineUniformiv;
    long glGetActiveSubroutineUniformName;
    long glGetActiveSubroutineName;
    long glUniformSubroutinesuiv;
    long glGetUniformSubroutineuiv;
    long glGetProgramStageiv;
    long glPatchParameteri;
    long glPatchParameterfv;
    long glBindTransformFeedback;
    long glDeleteTransformFeedbacks;
    long glGenTransformFeedbacks;
    long glIsTransformFeedback;
    long glPauseTransformFeedback;
    long glResumeTransformFeedback;
    long glDrawTransformFeedback;
    long glDrawTransformFeedbackStream;
    long glBeginQueryIndexed;
    long glEndQueryIndexed;
    long glGetQueryIndexediv;
    long glReleaseShaderCompiler;
    long glShaderBinary;
    long glGetShaderPrecisionFormat;
    long glDepthRangef;
    long glClearDepthf;
    long glGetProgramBinary;
    long glProgramBinary;
    long glProgramParameteri;
    long glUseProgramStages;
    long glActiveShaderProgram;
    long glCreateShaderProgramv;
    long glBindProgramPipeline;
    long glDeleteProgramPipelines;
    long glGenProgramPipelines;
    long glIsProgramPipeline;
    long glGetProgramPipelineiv;
    long glProgramUniform1i;
    long glProgramUniform2i;
    long glProgramUniform3i;
    long glProgramUniform4i;
    long glProgramUniform1f;
    long glProgramUniform2f;
    long glProgramUniform3f;
    long glProgramUniform4f;
    long glProgramUniform1d;
    long glProgramUniform2d;
    long glProgramUniform3d;
    long glProgramUniform4d;
    long glProgramUniform1iv;
    long glProgramUniform2iv;
    long glProgramUniform3iv;
    long glProgramUniform4iv;
    long glProgramUniform1fv;
    long glProgramUniform2fv;
    long glProgramUniform3fv;
    long glProgramUniform4fv;
    long glProgramUniform1dv;
    long glProgramUniform2dv;
    long glProgramUniform3dv;
    long glProgramUniform4dv;
    long glProgramUniform1ui;
    long glProgramUniform2ui;
    long glProgramUniform3ui;
    long glProgramUniform4ui;
    long glProgramUniform1uiv;
    long glProgramUniform2uiv;
    long glProgramUniform3uiv;
    long glProgramUniform4uiv;
    long glProgramUniformMatrix2fv;
    long glProgramUniformMatrix3fv;
    long glProgramUniformMatrix4fv;
    long glProgramUniformMatrix2dv;
    long glProgramUniformMatrix3dv;
    long glProgramUniformMatrix4dv;
    long glProgramUniformMatrix2x3fv;
    long glProgramUniformMatrix3x2fv;
    long glProgramUniformMatrix2x4fv;
    long glProgramUniformMatrix4x2fv;
    long glProgramUniformMatrix3x4fv;
    long glProgramUniformMatrix4x3fv;
    long glProgramUniformMatrix2x3dv;
    long glProgramUniformMatrix3x2dv;
    long glProgramUniformMatrix2x4dv;
    long glProgramUniformMatrix4x2dv;
    long glProgramUniformMatrix3x4dv;
    long glProgramUniformMatrix4x3dv;
    long glValidateProgramPipeline;
    long glGetProgramPipelineInfoLog;
    long glVertexAttribL1d;
    long glVertexAttribL2d;
    long glVertexAttribL3d;
    long glVertexAttribL4d;
    long glVertexAttribL1dv;
    long glVertexAttribL2dv;
    long glVertexAttribL3dv;
    long glVertexAttribL4dv;
    long glVertexAttribLPointer;
    long glGetVertexAttribLdv;
    long glViewportArrayv;
    long glViewportIndexedf;
    long glViewportIndexedfv;
    long glScissorArrayv;
    long glScissorIndexed;
    long glScissorIndexedv;
    long glDepthRangeArrayv;
    long glDepthRangeIndexed;
    long glGetFloati_v;
    long glGetDoublei_v;
    long glGetActiveAtomicCounterBufferiv;
    long glTexStorage1D;
    long glTexStorage2D;
    long glTexStorage3D;
    long glDrawTransformFeedbackInstanced;
    long glDrawTransformFeedbackStreamInstanced;
    long glDrawArraysInstancedBaseInstance;
    long glDrawElementsInstancedBaseInstance;
    long glDrawElementsInstancedBaseVertexBaseInstance;
    long glBindImageTexture;
    long glMemoryBarrier;
    long glGetInternalformativ;
    long glClearBufferData;
    long glClearBufferSubData;
    long glDispatchCompute;
    long glDispatchComputeIndirect;
    long glCopyImageSubData;
    long glDebugMessageControl;
    long glDebugMessageInsert;
    long glDebugMessageCallback;
    long glGetDebugMessageLog;
    long glPushDebugGroup;
    long glPopDebugGroup;
    long glObjectLabel;
    long glGetObjectLabel;
    long glObjectPtrLabel;
    long glGetObjectPtrLabel;
    long glFramebufferParameteri;
    long glGetFramebufferParameteriv;
    long glGetInternalformati64v;
    long glInvalidateTexSubImage;
    long glInvalidateTexImage;
    long glInvalidateBufferSubData;
    long glInvalidateBufferData;
    long glInvalidateFramebuffer;
    long glInvalidateSubFramebuffer;
    long glMultiDrawArraysIndirect;
    long glMultiDrawElementsIndirect;
    long glGetProgramInterfaceiv;
    long glGetProgramResourceIndex;
    long glGetProgramResourceName;
    long glGetProgramResourceiv;
    long glGetProgramResourceLocation;
    long glGetProgramResourceLocationIndex;
    long glShaderStorageBlockBinding;
    long glTexBufferRange;
    long glTexStorage2DMultisample;
    long glTexStorage3DMultisample;
    long glTextureView;
    long glBindVertexBuffer;
    long glVertexAttribFormat;
    long glVertexAttribIFormat;
    long glVertexAttribLFormat;
    long glVertexAttribBinding;
    long glVertexBindingDivisor;
    long glBufferStorage;
    long glClearTexImage;
    long glClearTexSubImage;
    long glBindBuffersBase;
    long glBindBuffersRange;
    long glBindTextures;
    long glBindSamplers;
    long glBindImageTextures;
    long glBindVertexBuffers;
    long glClipControl;
    long glCreateTransformFeedbacks;
    long glTransformFeedbackBufferBase;
    long glTransformFeedbackBufferRange;
    long glGetTransformFeedbackiv;
    long glGetTransformFeedbacki_v;
    long glGetTransformFeedbacki64_v;
    long glCreateBuffers;
    long glNamedBufferStorage;
    long glNamedBufferData;
    long glNamedBufferSubData;
    long glCopyNamedBufferSubData;
    long glClearNamedBufferData;
    long glClearNamedBufferSubData;
    long glMapNamedBuffer;
    long glMapNamedBufferRange;
    long glUnmapNamedBuffer;
    long glFlushMappedNamedBufferRange;
    long glGetNamedBufferParameteriv;
    long glGetNamedBufferParameteri64v;
    long glGetNamedBufferPointerv;
    long glGetNamedBufferSubData;
    long glCreateFramebuffers;
    long glNamedFramebufferRenderbuffer;
    long glNamedFramebufferParameteri;
    long glNamedFramebufferTexture;
    long glNamedFramebufferTextureLayer;
    long glNamedFramebufferDrawBuffer;
    long glNamedFramebufferDrawBuffers;
    long glNamedFramebufferReadBuffer;
    long glInvalidateNamedFramebufferData;
    long glInvalidateNamedFramebufferSubData;
    long glClearNamedFramebufferiv;
    long glClearNamedFramebufferuiv;
    long glClearNamedFramebufferfv;
    long glClearNamedFramebufferfi;
    long glBlitNamedFramebuffer;
    long glCheckNamedFramebufferStatus;
    long glGetNamedFramebufferParameteriv;
    long glGetNamedFramebufferAttachmentParameteriv;
    long glCreateRenderbuffers;
    long glNamedRenderbufferStorage;
    long glNamedRenderbufferStorageMultisample;
    long glGetNamedRenderbufferParameteriv;
    long glCreateTextures;
    long glTextureBuffer;
    long glTextureBufferRange;
    long glTextureStorage1D;
    long glTextureStorage2D;
    long glTextureStorage3D;
    long glTextureStorage2DMultisample;
    long glTextureStorage3DMultisample;
    long glTextureSubImage1D;
    long glTextureSubImage2D;
    long glTextureSubImage3D;
    long glCompressedTextureSubImage1D;
    long glCompressedTextureSubImage2D;
    long glCompressedTextureSubImage3D;
    long glCopyTextureSubImage1D;
    long glCopyTextureSubImage2D;
    long glCopyTextureSubImage3D;
    long glTextureParameterf;
    long glTextureParameterfv;
    long glTextureParameteri;
    long glTextureParameterIiv;
    long glTextureParameterIuiv;
    long glTextureParameteriv;
    long glGenerateTextureMipmap;
    long glBindTextureUnit;
    long glGetTextureImage;
    long glGetCompressedTextureImage;
    long glGetTextureLevelParameterfv;
    long glGetTextureLevelParameteriv;
    long glGetTextureParameterfv;
    long glGetTextureParameterIiv;
    long glGetTextureParameterIuiv;
    long glGetTextureParameteriv;
    long glCreateVertexArrays;
    long glDisableVertexArrayAttrib;
    long glEnableVertexArrayAttrib;
    long glVertexArrayElementBuffer;
    long glVertexArrayVertexBuffer;
    long glVertexArrayVertexBuffers;
    long glVertexArrayAttribFormat;
    long glVertexArrayAttribIFormat;
    long glVertexArrayAttribLFormat;
    long glVertexArrayAttribBinding;
    long glVertexArrayBindingDivisor;
    long glGetVertexArrayiv;
    long glGetVertexArrayIndexediv;
    long glGetVertexArrayIndexed64iv;
    long glCreateSamplers;
    long glCreateProgramPipelines;
    long glCreateQueries;
    long glMemoryBarrierByRegion;
    long glGetTextureSubImage;
    long glGetCompressedTextureSubImage;
    long glTextureBarrier;
    long glGetGraphicsResetStatus;
    long glReadnPixels;
    long glGetnUniformfv;
    long glGetnUniformiv;
    long glGetnUniformuiv;
    long glFrameTerminatorGREMEDY;
    long glStringMarkerGREMEDY;
    long glMapTexture2DINTEL;
    long glUnmapTexture2DINTEL;
    long glSyncTextureINTEL;
    long glMultiDrawArraysIndirectBindlessNV;
    long glMultiDrawElementsIndirectBindlessNV;
    long glGetTextureHandleNV;
    long glGetTextureSamplerHandleNV;
    long glMakeTextureHandleResidentNV;
    long glMakeTextureHandleNonResidentNV;
    long glGetImageHandleNV;
    long glMakeImageHandleResidentNV;
    long glMakeImageHandleNonResidentNV;
    long glUniformHandleui64NV;
    long glUniformHandleui64vNV;
    long glProgramUniformHandleui64NV;
    long glProgramUniformHandleui64vNV;
    long glIsTextureHandleResidentNV;
    long glIsImageHandleResidentNV;
    long glBlendParameteriNV;
    long glBlendBarrierNV;
    long glBeginConditionalRenderNV;
    long glEndConditionalRenderNV;
    long glCopyImageSubDataNV;
    long glDepthRangedNV;
    long glClearDepthdNV;
    long glDepthBoundsdNV;
    long glDrawTextureNV;
    long glGetMapControlPointsNV;
    long glMapControlPointsNV;
    long glMapParameterfvNV;
    long glMapParameterivNV;
    long glGetMapParameterfvNV;
    long glGetMapParameterivNV;
    long glGetMapAttribParameterfvNV;
    long glGetMapAttribParameterivNV;
    long glEvalMapsNV;
    long glGetMultisamplefvNV;
    long glSampleMaskIndexedNV;
    long glTexRenderbufferNV;
    long glGenFencesNV;
    long glDeleteFencesNV;
    long glSetFenceNV;
    long glTestFenceNV;
    long glFinishFenceNV;
    long glIsFenceNV;
    long glGetFenceivNV;
    long glProgramNamedParameter4fNV;
    long glProgramNamedParameter4dNV;
    long glGetProgramNamedParameterfvNV;
    long glGetProgramNamedParameterdvNV;
    long glRenderbufferStorageMultisampleCoverageNV;
    long glProgramVertexLimitNV;
    long glProgramLocalParameterI4iNV;
    long glProgramLocalParameterI4ivNV;
    long glProgramLocalParametersI4ivNV;
    long glProgramLocalParameterI4uiNV;
    long glProgramLocalParameterI4uivNV;
    long glProgramLocalParametersI4uivNV;
    long glProgramEnvParameterI4iNV;
    long glProgramEnvParameterI4ivNV;
    long glProgramEnvParametersI4ivNV;
    long glProgramEnvParameterI4uiNV;
    long glProgramEnvParameterI4uivNV;
    long glProgramEnvParametersI4uivNV;
    long glGetProgramLocalParameterIivNV;
    long glGetProgramLocalParameterIuivNV;
    long glGetProgramEnvParameterIivNV;
    long glGetProgramEnvParameterIuivNV;
    long glUniform1i64NV;
    long glUniform2i64NV;
    long glUniform3i64NV;
    long glUniform4i64NV;
    long glUniform1i64vNV;
    long glUniform2i64vNV;
    long glUniform3i64vNV;
    long glUniform4i64vNV;
    long glUniform1ui64NV;
    long glUniform2ui64NV;
    long glUniform3ui64NV;
    long glUniform4ui64NV;
    long glUniform1ui64vNV;
    long glUniform2ui64vNV;
    long glUniform3ui64vNV;
    long glUniform4ui64vNV;
    long glGetUniformi64vNV;
    long glGetUniformui64vNV;
    long glProgramUniform1i64NV;
    long glProgramUniform2i64NV;
    long glProgramUniform3i64NV;
    long glProgramUniform4i64NV;
    long glProgramUniform1i64vNV;
    long glProgramUniform2i64vNV;
    long glProgramUniform3i64vNV;
    long glProgramUniform4i64vNV;
    long glProgramUniform1ui64NV;
    long glProgramUniform2ui64NV;
    long glProgramUniform3ui64NV;
    long glProgramUniform4ui64NV;
    long glProgramUniform1ui64vNV;
    long glProgramUniform2ui64vNV;
    long glProgramUniform3ui64vNV;
    long glProgramUniform4ui64vNV;
    long glVertex2hNV;
    long glVertex3hNV;
    long glVertex4hNV;
    long glNormal3hNV;
    long glColor3hNV;
    long glColor4hNV;
    long glTexCoord1hNV;
    long glTexCoord2hNV;
    long glTexCoord3hNV;
    long glTexCoord4hNV;
    long glMultiTexCoord1hNV;
    long glMultiTexCoord2hNV;
    long glMultiTexCoord3hNV;
    long glMultiTexCoord4hNV;
    long glFogCoordhNV;
    long glSecondaryColor3hNV;
    long glVertexWeighthNV;
    long glVertexAttrib1hNV;
    long glVertexAttrib2hNV;
    long glVertexAttrib3hNV;
    long glVertexAttrib4hNV;
    long glVertexAttribs1hvNV;
    long glVertexAttribs2hvNV;
    long glVertexAttribs3hvNV;
    long glVertexAttribs4hvNV;
    long glGenOcclusionQueriesNV;
    long glDeleteOcclusionQueriesNV;
    long glIsOcclusionQueryNV;
    long glBeginOcclusionQueryNV;
    long glEndOcclusionQueryNV;
    long glGetOcclusionQueryuivNV;
    long glGetOcclusionQueryivNV;
    long glProgramBufferParametersfvNV;
    long glProgramBufferParametersIivNV;
    long glProgramBufferParametersIuivNV;
    long glPathCommandsNV;
    long glPathCoordsNV;
    long glPathSubCommandsNV;
    long glPathSubCoordsNV;
    long glPathStringNV;
    long glPathGlyphsNV;
    long glPathGlyphRangeNV;
    long glWeightPathsNV;
    long glCopyPathNV;
    long glInterpolatePathsNV;
    long glTransformPathNV;
    long glPathParameterivNV;
    long glPathParameteriNV;
    long glPathParameterfvNV;
    long glPathParameterfNV;
    long glPathDashArrayNV;
    long glGenPathsNV;
    long glDeletePathsNV;
    long glIsPathNV;
    long glPathStencilFuncNV;
    long glPathStencilDepthOffsetNV;
    long glStencilFillPathNV;
    long glStencilStrokePathNV;
    long glStencilFillPathInstancedNV;
    long glStencilStrokePathInstancedNV;
    long glPathCoverDepthFuncNV;
    long glPathColorGenNV;
    long glPathTexGenNV;
    long glPathFogGenNV;
    long glCoverFillPathNV;
    long glCoverStrokePathNV;
    long glCoverFillPathInstancedNV;
    long glCoverStrokePathInstancedNV;
    long glGetPathParameterivNV;
    long glGetPathParameterfvNV;
    long glGetPathCommandsNV;
    long glGetPathCoordsNV;
    long glGetPathDashArrayNV;
    long glGetPathMetricsNV;
    long glGetPathMetricRangeNV;
    long glGetPathSpacingNV;
    long glGetPathColorGenivNV;
    long glGetPathColorGenfvNV;
    long glGetPathTexGenivNV;
    long glGetPathTexGenfvNV;
    long glIsPointInFillPathNV;
    long glIsPointInStrokePathNV;
    long glGetPathLengthNV;
    long glPointAlongPathNV;
    long glPixelDataRangeNV;
    long glFlushPixelDataRangeNV;
    long glPointParameteriNV;
    long glPointParameterivNV;
    long glPresentFrameKeyedNV;
    long glPresentFrameDualFillNV;
    long glGetVideoivNV;
    long glGetVideouivNV;
    long glGetVideoi64vNV;
    long glGetVideoui64vNV;
    long glPrimitiveRestartNV;
    long glPrimitiveRestartIndexNV;
    long glLoadProgramNV;
    long glBindProgramNV;
    long glDeleteProgramsNV;
    long glGenProgramsNV;
    long glGetProgramivNV;
    long glGetProgramStringNV;
    long glIsProgramNV;
    long glAreProgramsResidentNV;
    long glRequestResidentProgramsNV;
    long glCombinerParameterfNV;
    long glCombinerParameterfvNV;
    long glCombinerParameteriNV;
    long glCombinerParameterivNV;
    long glCombinerInputNV;
    long glCombinerOutputNV;
    long glFinalCombinerInputNV;
    long glGetCombinerInputParameterfvNV;
    long glGetCombinerInputParameterivNV;
    long glGetCombinerOutputParameterfvNV;
    long glGetCombinerOutputParameterivNV;
    long glGetFinalCombinerInputParameterfvNV;
    long glGetFinalCombinerInputParameterivNV;
    long glCombinerStageParameterfvNV;
    long glGetCombinerStageParameterfvNV;
    long glMakeBufferResidentNV;
    long glMakeBufferNonResidentNV;
    long glIsBufferResidentNV;
    long glMakeNamedBufferResidentNV;
    long glMakeNamedBufferNonResidentNV;
    long glIsNamedBufferResidentNV;
    long glGetBufferParameterui64vNV;
    long glGetNamedBufferParameterui64vNV;
    long glGetIntegerui64vNV;
    long glUniformui64NV;
    long glUniformui64vNV;
    long glProgramUniformui64NV;
    long glProgramUniformui64vNV;
    long glTextureBarrierNV;
    long glTexImage2DMultisampleCoverageNV;
    long glTexImage3DMultisampleCoverageNV;
    long glTextureImage2DMultisampleNV;
    long glTextureImage3DMultisampleNV;
    long glTextureImage2DMultisampleCoverageNV;
    long glTextureImage3DMultisampleCoverageNV;
    long glBindBufferRangeNV;
    long glBindBufferOffsetNV;
    long glBindBufferBaseNV;
    long glTransformFeedbackAttribsNV;
    long glTransformFeedbackVaryingsNV;
    long glBeginTransformFeedbackNV;
    long glEndTransformFeedbackNV;
    long glGetVaryingLocationNV;
    long glGetActiveVaryingNV;
    long glActiveVaryingNV;
    long glGetTransformFeedbackVaryingNV;
    long glBindTransformFeedbackNV;
    long glDeleteTransformFeedbacksNV;
    long glGenTransformFeedbacksNV;
    long glIsTransformFeedbackNV;
    long glPauseTransformFeedbackNV;
    long glResumeTransformFeedbackNV;
    long glDrawTransformFeedbackNV;
    long glVertexArrayRangeNV;
    long glFlushVertexArrayRangeNV;
    long glAllocateMemoryNV;
    long glFreeMemoryNV;
    long glVertexAttribL1i64NV;
    long glVertexAttribL2i64NV;
    long glVertexAttribL3i64NV;
    long glVertexAttribL4i64NV;
    long glVertexAttribL1i64vNV;
    long glVertexAttribL2i64vNV;
    long glVertexAttribL3i64vNV;
    long glVertexAttribL4i64vNV;
    long glVertexAttribL1ui64NV;
    long glVertexAttribL2ui64NV;
    long glVertexAttribL3ui64NV;
    long glVertexAttribL4ui64NV;
    long glVertexAttribL1ui64vNV;
    long glVertexAttribL2ui64vNV;
    long glVertexAttribL3ui64vNV;
    long glVertexAttribL4ui64vNV;
    long glGetVertexAttribLi64vNV;
    long glGetVertexAttribLui64vNV;
    long glVertexAttribLFormatNV;
    long glBufferAddressRangeNV;
    long glVertexFormatNV;
    long glNormalFormatNV;
    long glColorFormatNV;
    long glIndexFormatNV;
    long glTexCoordFormatNV;
    long glEdgeFlagFormatNV;
    long glSecondaryColorFormatNV;
    long glFogCoordFormatNV;
    long glVertexAttribFormatNV;
    long glVertexAttribIFormatNV;
    long glGetIntegerui64i_vNV;
    long glExecuteProgramNV;
    long glGetProgramParameterfvNV;
    long glGetProgramParameterdvNV;
    long glGetTrackMatrixivNV;
    long glGetVertexAttribfvNV;
    long glGetVertexAttribdvNV;
    long glGetVertexAttribivNV;
    long glGetVertexAttribPointervNV;
    long glProgramParameter4fNV;
    long glProgramParameter4dNV;
    long glProgramParameters4fvNV;
    long glProgramParameters4dvNV;
    long glTrackMatrixNV;
    long glVertexAttribPointerNV;
    long glVertexAttrib1sNV;
    long glVertexAttrib1fNV;
    long glVertexAttrib1dNV;
    long glVertexAttrib2sNV;
    long glVertexAttrib2fNV;
    long glVertexAttrib2dNV;
    long glVertexAttrib3sNV;
    long glVertexAttrib3fNV;
    long glVertexAttrib3dNV;
    long glVertexAttrib4sNV;
    long glVertexAttrib4fNV;
    long glVertexAttrib4dNV;
    long glVertexAttrib4ubNV;
    long glVertexAttribs1svNV;
    long glVertexAttribs1fvNV;
    long glVertexAttribs1dvNV;
    long glVertexAttribs2svNV;
    long glVertexAttribs2fvNV;
    long glVertexAttribs2dvNV;
    long glVertexAttribs3svNV;
    long glVertexAttribs3fvNV;
    long glVertexAttribs3dvNV;
    long glVertexAttribs4svNV;
    long glVertexAttribs4fvNV;
    long glVertexAttribs4dvNV;
    long glBeginVideoCaptureNV;
    long glBindVideoCaptureStreamBufferNV;
    long glBindVideoCaptureStreamTextureNV;
    long glEndVideoCaptureNV;
    long glGetVideoCaptureivNV;
    long glGetVideoCaptureStreamivNV;
    long glGetVideoCaptureStreamfvNV;
    long glGetVideoCaptureStreamdvNV;
    long glVideoCaptureNV;
    long glVideoCaptureStreamParameterivNV;
    long glVideoCaptureStreamParameterfvNV;
    long glVideoCaptureStreamParameterdvNV;

    private boolean AMD_debug_output_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress(new String[]{"glDebugMessageEnableAMD", "glDebugMessageEnableAMDX"});
        this.glDebugMessageEnableAMD = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress(new String[]{"glDebugMessageInsertAMD", "glDebugMessageInsertAMDX"});
        this.glDebugMessageInsertAMD = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress(new String[]{"glDebugMessageCallbackAMD", "glDebugMessageCallbackAMDX"});
        this.glDebugMessageCallbackAMD = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress(new String[]{"glGetDebugMessageLogAMD", "glGetDebugMessageLogAMDX"});
        this.glGetDebugMessageLogAMD = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean AMD_draw_buffers_blend_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlendFuncIndexedAMD");
        this.glBlendFuncIndexedAMD = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBlendFuncSeparateIndexedAMD");
        this.glBlendFuncSeparateIndexedAMD = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glBlendEquationIndexedAMD");
        this.glBlendEquationIndexedAMD = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBlendEquationSeparateIndexedAMD");
        this.glBlendEquationSeparateIndexedAMD = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean AMD_interleaved_elements_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexAttribParameteriAMD");
        this.glVertexAttribParameteriAMD = functionAddress;
        return functionAddress != 0;
    }

    private boolean AMD_multi_draw_indirect_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMultiDrawArraysIndirectAMD");
        this.glMultiDrawArraysIndirectAMD = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMultiDrawElementsIndirectAMD");
        this.glMultiDrawElementsIndirectAMD = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean AMD_name_gen_delete_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGenNamesAMD");
        this.glGenNamesAMD = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteNamesAMD");
        this.glDeleteNamesAMD = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glIsNameAMD");
        this.glIsNameAMD = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean AMD_performance_monitor_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetPerfMonitorGroupsAMD");
        this.glGetPerfMonitorGroupsAMD = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetPerfMonitorCountersAMD");
        this.glGetPerfMonitorCountersAMD = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetPerfMonitorGroupStringAMD");
        this.glGetPerfMonitorGroupStringAMD = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetPerfMonitorCounterStringAMD");
        this.glGetPerfMonitorCounterStringAMD = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetPerfMonitorCounterInfoAMD");
        this.glGetPerfMonitorCounterInfoAMD = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGenPerfMonitorsAMD");
        this.glGenPerfMonitorsAMD = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glDeletePerfMonitorsAMD");
        this.glDeletePerfMonitorsAMD = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glSelectPerfMonitorCountersAMD");
        this.glSelectPerfMonitorCountersAMD = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glBeginPerfMonitorAMD");
        this.glBeginPerfMonitorAMD = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glEndPerfMonitorAMD");
        this.glEndPerfMonitorAMD = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetPerfMonitorCounterDataAMD");
        this.glGetPerfMonitorCounterDataAMD = functionAddress11;
        return z10 & (functionAddress11 != 0);
    }

    private boolean AMD_sample_positions_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glSetMultisamplefvAMD");
        this.glSetMultisamplefvAMD = functionAddress;
        return functionAddress != 0;
    }

    private boolean AMD_sparse_texture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTexStorageSparseAMD");
        this.glTexStorageSparseAMD = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glTextureStorageSparseAMD");
        this.glTextureStorageSparseAMD = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean AMD_stencil_operation_extended_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glStencilOpValueAMD");
        this.glStencilOpValueAMD = functionAddress;
        return functionAddress != 0;
    }

    private boolean AMD_vertex_shader_tessellator_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTessellationFactorAMD");
        this.glTessellationFactorAMD = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glTessellationModeAMD");
        this.glTessellationModeAMD = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean APPLE_element_array_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glElementPointerAPPLE");
        this.glElementPointerAPPLE = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawElementArrayAPPLE");
        this.glDrawElementArrayAPPLE = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDrawRangeElementArrayAPPLE");
        this.glDrawRangeElementArrayAPPLE = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glMultiDrawElementArrayAPPLE");
        this.glMultiDrawElementArrayAPPLE = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glMultiDrawRangeElementArrayAPPLE");
        this.glMultiDrawRangeElementArrayAPPLE = functionAddress5;
        return z4 & (functionAddress5 != 0);
    }

    private boolean APPLE_fence_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGenFencesAPPLE");
        this.glGenFencesAPPLE = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteFencesAPPLE");
        this.glDeleteFencesAPPLE = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glSetFenceAPPLE");
        this.glSetFenceAPPLE = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glIsFenceAPPLE");
        this.glIsFenceAPPLE = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glTestFenceAPPLE");
        this.glTestFenceAPPLE = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glFinishFenceAPPLE");
        this.glFinishFenceAPPLE = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glTestObjectAPPLE");
        this.glTestObjectAPPLE = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glFinishObjectAPPLE");
        this.glFinishObjectAPPLE = functionAddress8;
        return z7 & (functionAddress8 != 0);
    }

    private boolean APPLE_flush_buffer_range_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBufferParameteriAPPLE");
        this.glBufferParameteriAPPLE = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFlushMappedBufferRangeAPPLE");
        this.glFlushMappedBufferRangeAPPLE = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean APPLE_object_purgeable_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glObjectPurgeableAPPLE");
        this.glObjectPurgeableAPPLE = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glObjectUnpurgeableAPPLE");
        this.glObjectUnpurgeableAPPLE = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetObjectParameterivAPPLE");
        this.glGetObjectParameterivAPPLE = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean APPLE_texture_range_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTextureRangeAPPLE");
        this.glTextureRangeAPPLE = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetTexParameterPointervAPPLE");
        this.glGetTexParameterPointervAPPLE = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean APPLE_vertex_array_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindVertexArrayAPPLE");
        this.glBindVertexArrayAPPLE = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteVertexArraysAPPLE");
        this.glDeleteVertexArraysAPPLE = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGenVertexArraysAPPLE");
        this.glGenVertexArraysAPPLE = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glIsVertexArrayAPPLE");
        this.glIsVertexArrayAPPLE = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean APPLE_vertex_array_range_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexArrayRangeAPPLE");
        this.glVertexArrayRangeAPPLE = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFlushVertexArrayRangeAPPLE");
        this.glFlushVertexArrayRangeAPPLE = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glVertexArrayParameteriAPPLE");
        this.glVertexArrayParameteriAPPLE = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean APPLE_vertex_program_evaluators_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glEnableVertexAttribAPPLE");
        this.glEnableVertexAttribAPPLE = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDisableVertexAttribAPPLE");
        this.glDisableVertexAttribAPPLE = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glIsVertexAttribEnabledAPPLE");
        this.glIsVertexAttribEnabledAPPLE = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glMapVertexAttrib1dAPPLE");
        this.glMapVertexAttrib1dAPPLE = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glMapVertexAttrib1fAPPLE");
        this.glMapVertexAttrib1fAPPLE = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glMapVertexAttrib2dAPPLE");
        this.glMapVertexAttrib2dAPPLE = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glMapVertexAttrib2fAPPLE");
        this.glMapVertexAttrib2fAPPLE = functionAddress7;
        return z6 & (functionAddress7 != 0);
    }

    private boolean ARB_ES2_compatibility_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glReleaseShaderCompiler");
        this.glReleaseShaderCompiler = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glShaderBinary");
        this.glShaderBinary = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetShaderPrecisionFormat");
        this.glGetShaderPrecisionFormat = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glDepthRangef");
        this.glDepthRangef = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glClearDepthf");
        this.glClearDepthf = functionAddress5;
        return z4 & (functionAddress5 != 0);
    }

    private boolean ARB_ES3_1_compatibility_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMemoryBarrierByRegion");
        this.glMemoryBarrierByRegion = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_base_instance_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawArraysInstancedBaseInstance");
        this.glDrawArraysInstancedBaseInstance = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawElementsInstancedBaseInstance");
        this.glDrawElementsInstancedBaseInstance = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertexBaseInstance");
        this.glDrawElementsInstancedBaseVertexBaseInstance = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean ARB_bindless_texture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetTextureHandleARB");
        this.glGetTextureHandleARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetTextureSamplerHandleARB");
        this.glGetTextureSamplerHandleARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glMakeTextureHandleResidentARB");
        this.glMakeTextureHandleResidentARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glMakeTextureHandleNonResidentARB");
        this.glMakeTextureHandleNonResidentARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetImageHandleARB");
        this.glGetImageHandleARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glMakeImageHandleResidentARB");
        this.glMakeImageHandleResidentARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glMakeImageHandleNonResidentARB");
        this.glMakeImageHandleNonResidentARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glUniformHandleui64ARB");
        this.glUniformHandleui64ARB = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glUniformHandleui64vARB");
        this.glUniformHandleui64vARB = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glProgramUniformHandleui64ARB");
        this.glProgramUniformHandleui64ARB = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glProgramUniformHandleui64vARB");
        this.glProgramUniformHandleui64vARB = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glIsTextureHandleResidentARB");
        this.glIsTextureHandleResidentARB = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glIsImageHandleResidentARB");
        this.glIsImageHandleResidentARB = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glVertexAttribL1ui64ARB");
        this.glVertexAttribL1ui64ARB = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glVertexAttribL1ui64vARB");
        this.glVertexAttribL1ui64vARB = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glGetVertexAttribLui64vARB");
        this.glGetVertexAttribLui64vARB = functionAddress16;
        return z15 & (functionAddress16 != 0);
    }

    private boolean ARB_blend_func_extended_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindFragDataLocationIndexed");
        this.glBindFragDataLocationIndexed = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetFragDataIndex");
        this.glGetFragDataIndex = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_buffer_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindBufferARB");
        this.glBindBufferARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteBuffersARB");
        this.glDeleteBuffersARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGenBuffersARB");
        this.glGenBuffersARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glIsBufferARB");
        this.glIsBufferARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glBufferDataARB");
        this.glBufferDataARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glBufferSubDataARB");
        this.glBufferSubDataARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetBufferSubDataARB");
        this.glGetBufferSubDataARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glMapBufferARB");
        this.glMapBufferARB = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glUnmapBufferARB");
        this.glUnmapBufferARB = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glGetBufferParameterivARB");
        this.glGetBufferParameterivARB = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetBufferPointervARB");
        this.glGetBufferPointervARB = functionAddress11;
        return z10 & (functionAddress11 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_buffer_storage_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            r7 = this;
            r0 = r7
            java.lang.String r1 = "glBufferStorage"
            long r1 = org.lwjgl.opengl.GLContext.getFunctionAddress(r1)
            r2 = r1; r1 = r0; r0 = r2; 
            r1.glBufferStorage = r2
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L2e
            r1 = r7
            java.lang.String r2 = "glNamedBufferStorageEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glNamedBufferStorageEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L32
        L2e:
            r1 = 1
            goto L33
        L32:
            r1 = 0
        L33:
            r0 = r0 & r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_buffer_storage_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean ARB_cl_event_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCreateSyncFromCLeventARB");
        this.glCreateSyncFromCLeventARB = functionAddress;
        return functionAddress != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_clear_buffer_object_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            r7 = this;
            r0 = r7
            java.lang.String r1 = "glClearBufferData"
            long r1 = org.lwjgl.opengl.GLContext.getFunctionAddress(r1)
            r2 = r1; r1 = r0; r0 = r2; 
            r1.glClearBufferData = r2
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L13
            r0 = 1
            goto L14
        L13:
            r0 = 0
        L14:
            r1 = r7
            java.lang.String r2 = "glClearBufferSubData"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glClearBufferSubData = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L27
            r1 = 1
            goto L28
        L27:
            r1 = 0
        L28:
            r0 = r0 & r1
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L43
            r1 = r7
            java.lang.String r2 = "glClearNamedBufferDataEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glClearNamedBufferDataEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L47
        L43:
            r1 = 1
            goto L48
        L47:
            r1 = 0
        L48:
            r0 = r0 & r1
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L63
            r1 = r7
            java.lang.String r2 = "glClearNamedBufferSubDataEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glClearNamedBufferSubDataEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L67
        L63:
            r1 = 1
            goto L68
        L67:
            r1 = 0
        L68:
            r0 = r0 & r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_clear_buffer_object_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean ARB_clear_texture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glClearTexImage");
        this.glClearTexImage = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glClearTexSubImage");
        this.glClearTexSubImage = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_clip_control_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glClipControl");
        this.glClipControl = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_color_buffer_float_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glClampColorARB");
        this.glClampColorARB = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_compute_shader_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDispatchCompute");
        this.glDispatchCompute = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDispatchComputeIndirect");
        this.glDispatchComputeIndirect = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_compute_variable_group_size_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDispatchComputeGroupSizeARB");
        this.glDispatchComputeGroupSizeARB = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_copy_buffer_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCopyBufferSubData");
        this.glCopyBufferSubData = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_copy_image_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCopyImageSubData");
        this.glCopyImageSubData = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_debug_output_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDebugMessageControlARB");
        this.glDebugMessageControlARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDebugMessageInsertARB");
        this.glDebugMessageInsertARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDebugMessageCallbackARB");
        this.glDebugMessageCallbackARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetDebugMessageLogARB");
        this.glGetDebugMessageLogARB = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean ARB_direct_state_access_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCreateTransformFeedbacks");
        this.glCreateTransformFeedbacks = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glTransformFeedbackBufferBase");
        this.glTransformFeedbackBufferBase = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glTransformFeedbackBufferRange");
        this.glTransformFeedbackBufferRange = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetTransformFeedbackiv");
        this.glGetTransformFeedbackiv = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetTransformFeedbacki_v");
        this.glGetTransformFeedbacki_v = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetTransformFeedbacki64_v");
        this.glGetTransformFeedbacki64_v = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glCreateBuffers");
        this.glCreateBuffers = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glNamedBufferStorage");
        this.glNamedBufferStorage = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glNamedBufferData");
        this.glNamedBufferData = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glNamedBufferSubData");
        this.glNamedBufferSubData = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glCopyNamedBufferSubData");
        this.glCopyNamedBufferSubData = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glClearNamedBufferData");
        this.glClearNamedBufferData = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glClearNamedBufferSubData");
        this.glClearNamedBufferSubData = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glMapNamedBuffer");
        this.glMapNamedBuffer = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glMapNamedBufferRange");
        this.glMapNamedBufferRange = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glUnmapNamedBuffer");
        this.glUnmapNamedBuffer = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glFlushMappedNamedBufferRange");
        this.glFlushMappedNamedBufferRange = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glGetNamedBufferParameteriv");
        this.glGetNamedBufferParameteriv = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glGetNamedBufferParameteri64v");
        this.glGetNamedBufferParameteri64v = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glGetNamedBufferPointerv");
        this.glGetNamedBufferPointerv = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glGetNamedBufferSubData");
        this.glGetNamedBufferSubData = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glCreateFramebuffers");
        this.glCreateFramebuffers = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glNamedFramebufferRenderbuffer");
        this.glNamedFramebufferRenderbuffer = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glNamedFramebufferParameteri");
        this.glNamedFramebufferParameteri = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glNamedFramebufferTexture");
        this.glNamedFramebufferTexture = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glNamedFramebufferTextureLayer");
        this.glNamedFramebufferTextureLayer = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glNamedFramebufferDrawBuffer");
        this.glNamedFramebufferDrawBuffer = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glNamedFramebufferDrawBuffers");
        this.glNamedFramebufferDrawBuffers = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glNamedFramebufferReadBuffer");
        this.glNamedFramebufferReadBuffer = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glInvalidateNamedFramebufferData");
        this.glInvalidateNamedFramebufferData = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glInvalidateNamedFramebufferSubData");
        this.glInvalidateNamedFramebufferSubData = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glClearNamedFramebufferiv");
        this.glClearNamedFramebufferiv = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glClearNamedFramebufferuiv");
        this.glClearNamedFramebufferuiv = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glClearNamedFramebufferfv");
        this.glClearNamedFramebufferfv = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glClearNamedFramebufferfi");
        this.glClearNamedFramebufferfi = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glBlitNamedFramebuffer");
        this.glBlitNamedFramebuffer = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glCheckNamedFramebufferStatus");
        this.glCheckNamedFramebufferStatus = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glGetNamedFramebufferParameteriv");
        this.glGetNamedFramebufferParameteriv = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glGetNamedFramebufferAttachmentParameteriv");
        this.glGetNamedFramebufferAttachmentParameteriv = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glCreateRenderbuffers");
        this.glCreateRenderbuffers = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glNamedRenderbufferStorage");
        this.glNamedRenderbufferStorage = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glNamedRenderbufferStorageMultisample");
        this.glNamedRenderbufferStorageMultisample = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glGetNamedRenderbufferParameteriv");
        this.glGetNamedRenderbufferParameteriv = functionAddress43;
        boolean z43 = z42 & (functionAddress43 != 0);
        long functionAddress44 = GLContext.getFunctionAddress("glCreateTextures");
        this.glCreateTextures = functionAddress44;
        boolean z44 = z43 & (functionAddress44 != 0);
        long functionAddress45 = GLContext.getFunctionAddress("glTextureBuffer");
        this.glTextureBuffer = functionAddress45;
        boolean z45 = z44 & (functionAddress45 != 0);
        long functionAddress46 = GLContext.getFunctionAddress("glTextureBufferRange");
        this.glTextureBufferRange = functionAddress46;
        boolean z46 = z45 & (functionAddress46 != 0);
        long functionAddress47 = GLContext.getFunctionAddress("glTextureStorage1D");
        this.glTextureStorage1D = functionAddress47;
        boolean z47 = z46 & (functionAddress47 != 0);
        long functionAddress48 = GLContext.getFunctionAddress("glTextureStorage2D");
        this.glTextureStorage2D = functionAddress48;
        boolean z48 = z47 & (functionAddress48 != 0);
        long functionAddress49 = GLContext.getFunctionAddress("glTextureStorage3D");
        this.glTextureStorage3D = functionAddress49;
        boolean z49 = z48 & (functionAddress49 != 0);
        long functionAddress50 = GLContext.getFunctionAddress("glTextureStorage2DMultisample");
        this.glTextureStorage2DMultisample = functionAddress50;
        boolean z50 = z49 & (functionAddress50 != 0);
        long functionAddress51 = GLContext.getFunctionAddress("glTextureStorage3DMultisample");
        this.glTextureStorage3DMultisample = functionAddress51;
        boolean z51 = z50 & (functionAddress51 != 0);
        long functionAddress52 = GLContext.getFunctionAddress("glTextureSubImage1D");
        this.glTextureSubImage1D = functionAddress52;
        boolean z52 = z51 & (functionAddress52 != 0);
        long functionAddress53 = GLContext.getFunctionAddress("glTextureSubImage2D");
        this.glTextureSubImage2D = functionAddress53;
        boolean z53 = z52 & (functionAddress53 != 0);
        long functionAddress54 = GLContext.getFunctionAddress("glTextureSubImage3D");
        this.glTextureSubImage3D = functionAddress54;
        boolean z54 = z53 & (functionAddress54 != 0);
        long functionAddress55 = GLContext.getFunctionAddress("glCompressedTextureSubImage1D");
        this.glCompressedTextureSubImage1D = functionAddress55;
        boolean z55 = z54 & (functionAddress55 != 0);
        long functionAddress56 = GLContext.getFunctionAddress("glCompressedTextureSubImage2D");
        this.glCompressedTextureSubImage2D = functionAddress56;
        boolean z56 = z55 & (functionAddress56 != 0);
        long functionAddress57 = GLContext.getFunctionAddress("glCompressedTextureSubImage3D");
        this.glCompressedTextureSubImage3D = functionAddress57;
        boolean z57 = z56 & (functionAddress57 != 0);
        long functionAddress58 = GLContext.getFunctionAddress("glCopyTextureSubImage1D");
        this.glCopyTextureSubImage1D = functionAddress58;
        boolean z58 = z57 & (functionAddress58 != 0);
        long functionAddress59 = GLContext.getFunctionAddress("glCopyTextureSubImage2D");
        this.glCopyTextureSubImage2D = functionAddress59;
        boolean z59 = z58 & (functionAddress59 != 0);
        long functionAddress60 = GLContext.getFunctionAddress("glCopyTextureSubImage3D");
        this.glCopyTextureSubImage3D = functionAddress60;
        boolean z60 = z59 & (functionAddress60 != 0);
        long functionAddress61 = GLContext.getFunctionAddress("glTextureParameterf");
        this.glTextureParameterf = functionAddress61;
        boolean z61 = z60 & (functionAddress61 != 0);
        long functionAddress62 = GLContext.getFunctionAddress("glTextureParameterfv");
        this.glTextureParameterfv = functionAddress62;
        boolean z62 = z61 & (functionAddress62 != 0);
        long functionAddress63 = GLContext.getFunctionAddress("glTextureParameteri");
        this.glTextureParameteri = functionAddress63;
        boolean z63 = z62 & (functionAddress63 != 0);
        long functionAddress64 = GLContext.getFunctionAddress("glTextureParameterIiv");
        this.glTextureParameterIiv = functionAddress64;
        boolean z64 = z63 & (functionAddress64 != 0);
        long functionAddress65 = GLContext.getFunctionAddress("glTextureParameterIuiv");
        this.glTextureParameterIuiv = functionAddress65;
        boolean z65 = z64 & (functionAddress65 != 0);
        long functionAddress66 = GLContext.getFunctionAddress("glTextureParameteriv");
        this.glTextureParameteriv = functionAddress66;
        boolean z66 = z65 & (functionAddress66 != 0);
        long functionAddress67 = GLContext.getFunctionAddress("glGenerateTextureMipmap");
        this.glGenerateTextureMipmap = functionAddress67;
        boolean z67 = z66 & (functionAddress67 != 0);
        long functionAddress68 = GLContext.getFunctionAddress("glBindTextureUnit");
        this.glBindTextureUnit = functionAddress68;
        boolean z68 = z67 & (functionAddress68 != 0);
        long functionAddress69 = GLContext.getFunctionAddress("glGetTextureImage");
        this.glGetTextureImage = functionAddress69;
        boolean z69 = z68 & (functionAddress69 != 0);
        long functionAddress70 = GLContext.getFunctionAddress("glGetCompressedTextureImage");
        this.glGetCompressedTextureImage = functionAddress70;
        boolean z70 = z69 & (functionAddress70 != 0);
        long functionAddress71 = GLContext.getFunctionAddress("glGetTextureLevelParameterfv");
        this.glGetTextureLevelParameterfv = functionAddress71;
        boolean z71 = z70 & (functionAddress71 != 0);
        long functionAddress72 = GLContext.getFunctionAddress("glGetTextureLevelParameteriv");
        this.glGetTextureLevelParameteriv = functionAddress72;
        boolean z72 = z71 & (functionAddress72 != 0);
        long functionAddress73 = GLContext.getFunctionAddress("glGetTextureParameterfv");
        this.glGetTextureParameterfv = functionAddress73;
        boolean z73 = z72 & (functionAddress73 != 0);
        long functionAddress74 = GLContext.getFunctionAddress("glGetTextureParameterIiv");
        this.glGetTextureParameterIiv = functionAddress74;
        boolean z74 = z73 & (functionAddress74 != 0);
        long functionAddress75 = GLContext.getFunctionAddress("glGetTextureParameterIuiv");
        this.glGetTextureParameterIuiv = functionAddress75;
        boolean z75 = z74 & (functionAddress75 != 0);
        long functionAddress76 = GLContext.getFunctionAddress("glGetTextureParameteriv");
        this.glGetTextureParameteriv = functionAddress76;
        boolean z76 = z75 & (functionAddress76 != 0);
        long functionAddress77 = GLContext.getFunctionAddress("glCreateVertexArrays");
        this.glCreateVertexArrays = functionAddress77;
        boolean z77 = z76 & (functionAddress77 != 0);
        long functionAddress78 = GLContext.getFunctionAddress("glDisableVertexArrayAttrib");
        this.glDisableVertexArrayAttrib = functionAddress78;
        boolean z78 = z77 & (functionAddress78 != 0);
        long functionAddress79 = GLContext.getFunctionAddress("glEnableVertexArrayAttrib");
        this.glEnableVertexArrayAttrib = functionAddress79;
        boolean z79 = z78 & (functionAddress79 != 0);
        long functionAddress80 = GLContext.getFunctionAddress("glVertexArrayElementBuffer");
        this.glVertexArrayElementBuffer = functionAddress80;
        boolean z80 = z79 & (functionAddress80 != 0);
        long functionAddress81 = GLContext.getFunctionAddress("glVertexArrayVertexBuffer");
        this.glVertexArrayVertexBuffer = functionAddress81;
        boolean z81 = z80 & (functionAddress81 != 0);
        long functionAddress82 = GLContext.getFunctionAddress("glVertexArrayVertexBuffers");
        this.glVertexArrayVertexBuffers = functionAddress82;
        boolean z82 = z81 & (functionAddress82 != 0);
        long functionAddress83 = GLContext.getFunctionAddress("glVertexArrayAttribFormat");
        this.glVertexArrayAttribFormat = functionAddress83;
        boolean z83 = z82 & (functionAddress83 != 0);
        long functionAddress84 = GLContext.getFunctionAddress("glVertexArrayAttribIFormat");
        this.glVertexArrayAttribIFormat = functionAddress84;
        boolean z84 = z83 & (functionAddress84 != 0);
        long functionAddress85 = GLContext.getFunctionAddress("glVertexArrayAttribLFormat");
        this.glVertexArrayAttribLFormat = functionAddress85;
        boolean z85 = z84 & (functionAddress85 != 0);
        long functionAddress86 = GLContext.getFunctionAddress("glVertexArrayAttribBinding");
        this.glVertexArrayAttribBinding = functionAddress86;
        boolean z86 = z85 & (functionAddress86 != 0);
        long functionAddress87 = GLContext.getFunctionAddress("glVertexArrayBindingDivisor");
        this.glVertexArrayBindingDivisor = functionAddress87;
        boolean z87 = z86 & (functionAddress87 != 0);
        long functionAddress88 = GLContext.getFunctionAddress("glGetVertexArrayiv");
        this.glGetVertexArrayiv = functionAddress88;
        boolean z88 = z87 & (functionAddress88 != 0);
        long functionAddress89 = GLContext.getFunctionAddress("glGetVertexArrayIndexediv");
        this.glGetVertexArrayIndexediv = functionAddress89;
        boolean z89 = z88 & (functionAddress89 != 0);
        long functionAddress90 = GLContext.getFunctionAddress("glGetVertexArrayIndexed64iv");
        this.glGetVertexArrayIndexed64iv = functionAddress90;
        boolean z90 = z89 & (functionAddress90 != 0);
        long functionAddress91 = GLContext.getFunctionAddress("glCreateSamplers");
        this.glCreateSamplers = functionAddress91;
        boolean z91 = z90 & (functionAddress91 != 0);
        long functionAddress92 = GLContext.getFunctionAddress("glCreateProgramPipelines");
        this.glCreateProgramPipelines = functionAddress92;
        boolean z92 = z91 & (functionAddress92 != 0);
        long functionAddress93 = GLContext.getFunctionAddress("glCreateQueries");
        this.glCreateQueries = functionAddress93;
        return z92 & (functionAddress93 != 0);
    }

    private boolean ARB_draw_buffers_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawBuffersARB");
        this.glDrawBuffersARB = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_draw_buffers_blend_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlendEquationiARB");
        this.glBlendEquationiARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBlendEquationSeparateiARB");
        this.glBlendEquationSeparateiARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glBlendFunciARB");
        this.glBlendFunciARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBlendFuncSeparateiARB");
        this.glBlendFuncSeparateiARB = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean ARB_draw_elements_base_vertex_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawElementsBaseVertex");
        this.glDrawElementsBaseVertex = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawRangeElementsBaseVertex");
        this.glDrawRangeElementsBaseVertex = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertex");
        this.glDrawElementsInstancedBaseVertex = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean ARB_draw_indirect_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawArraysIndirect");
        this.glDrawArraysIndirect = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawElementsIndirect");
        this.glDrawElementsIndirect = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_draw_instanced_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawArraysInstancedARB");
        this.glDrawArraysInstancedARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawElementsInstancedARB");
        this.glDrawElementsInstancedARB = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_framebuffer_no_attachments_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            r7 = this;
            r0 = r7
            java.lang.String r1 = "glFramebufferParameteri"
            long r1 = org.lwjgl.opengl.GLContext.getFunctionAddress(r1)
            r2 = r1; r1 = r0; r0 = r2; 
            r1.glFramebufferParameteri = r2
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            r1 = r7
            java.lang.String r2 = "glGetFramebufferParameteriv"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glGetFramebufferParameteriv = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L29
            r1 = 1
            goto L2a
        L29:
            r1 = 0
        L2a:
            r0 = r0 & r1
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L46
            r1 = r7
            java.lang.String r2 = "glNamedFramebufferParameteriEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glNamedFramebufferParameteriEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L4a
        L46:
            r1 = 1
            goto L4b
        L4a:
            r1 = 0
        L4b:
            r0 = r0 & r1
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L67
            r1 = r7
            java.lang.String r2 = "glGetNamedFramebufferParameterivEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glGetNamedFramebufferParameterivEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L6b
        L67:
            r1 = 1
            goto L6c
        L6b:
            r1 = 0
        L6c:
            r0 = r0 & r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_framebuffer_no_attachments_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean ARB_framebuffer_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glIsRenderbuffer");
        this.glIsRenderbuffer = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindRenderbuffer");
        this.glBindRenderbuffer = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDeleteRenderbuffers");
        this.glDeleteRenderbuffers = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGenRenderbuffers");
        this.glGenRenderbuffers = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glRenderbufferStorage");
        this.glRenderbufferStorage = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glRenderbufferStorageMultisample");
        this.glRenderbufferStorageMultisample = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetRenderbufferParameteriv");
        this.glGetRenderbufferParameteriv = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glIsFramebuffer");
        this.glIsFramebuffer = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glBindFramebuffer");
        this.glBindFramebuffer = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glDeleteFramebuffers");
        this.glDeleteFramebuffers = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGenFramebuffers");
        this.glGenFramebuffers = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glCheckFramebufferStatus");
        this.glCheckFramebufferStatus = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glFramebufferTexture1D");
        this.glFramebufferTexture1D = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glFramebufferTexture2D");
        this.glFramebufferTexture2D = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glFramebufferTexture3D");
        this.glFramebufferTexture3D = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glFramebufferTextureLayer");
        this.glFramebufferTextureLayer = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glFramebufferRenderbuffer");
        this.glFramebufferRenderbuffer = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameteriv");
        this.glGetFramebufferAttachmentParameteriv = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glBlitFramebuffer");
        this.glBlitFramebuffer = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glGenerateMipmap");
        this.glGenerateMipmap = functionAddress20;
        return z19 & (functionAddress20 != 0);
    }

    private boolean ARB_geometry_shader4_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProgramParameteriARB");
        this.glProgramParameteriARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFramebufferTextureARB");
        this.glFramebufferTextureARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glFramebufferTextureLayerARB");
        this.glFramebufferTextureLayerARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glFramebufferTextureFaceARB");
        this.glFramebufferTextureFaceARB = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean ARB_get_program_binary_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetProgramBinary");
        this.glGetProgramBinary = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glProgramBinary");
        this.glProgramBinary = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glProgramParameteri");
        this.glProgramParameteri = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean ARB_get_texture_sub_image_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetTextureSubImage");
        this.glGetTextureSubImage = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetCompressedTextureSubImage");
        this.glGetCompressedTextureSubImage = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0209  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_gpu_shader_fp64_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 957
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_gpu_shader_fp64_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_imaging_initNativeFunctionAddresses(boolean r8) {
        /*
            Method dump skipped, instruction units count: 876
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_imaging_initNativeFunctionAddresses(boolean):boolean");
    }

    private boolean ARB_indirect_parameters_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMultiDrawArraysIndirectCountARB");
        this.glMultiDrawArraysIndirectCountARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMultiDrawElementsIndirectCountARB");
        this.glMultiDrawElementsIndirectCountARB = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_instanced_arrays_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexAttribDivisorARB");
        this.glVertexAttribDivisorARB = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_internalformat_query_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetInternalformativ");
        this.glGetInternalformativ = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_internalformat_query2_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetInternalformati64v");
        this.glGetInternalformati64v = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_invalidate_subdata_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glInvalidateTexSubImage");
        this.glInvalidateTexSubImage = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glInvalidateTexImage");
        this.glInvalidateTexImage = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glInvalidateBufferSubData");
        this.glInvalidateBufferSubData = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glInvalidateBufferData");
        this.glInvalidateBufferData = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glInvalidateFramebuffer");
        this.glInvalidateFramebuffer = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glInvalidateSubFramebuffer");
        this.glInvalidateSubFramebuffer = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean ARB_map_buffer_range_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMapBufferRange");
        this.glMapBufferRange = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFlushMappedBufferRange");
        this.glFlushMappedBufferRange = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_matrix_palette_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCurrentPaletteMatrixARB");
        this.glCurrentPaletteMatrixARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMatrixIndexPointerARB");
        this.glMatrixIndexPointerARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glMatrixIndexubvARB");
        this.glMatrixIndexubvARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glMatrixIndexusvARB");
        this.glMatrixIndexusvARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glMatrixIndexuivARB");
        this.glMatrixIndexuivARB = functionAddress5;
        return z4 & (functionAddress5 != 0);
    }

    private boolean ARB_multi_bind_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindBuffersBase");
        this.glBindBuffersBase = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindBuffersRange");
        this.glBindBuffersRange = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glBindTextures");
        this.glBindTextures = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBindSamplers");
        this.glBindSamplers = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glBindImageTextures");
        this.glBindImageTextures = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glBindVertexBuffers");
        this.glBindVertexBuffers = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean ARB_multi_draw_indirect_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMultiDrawArraysIndirect");
        this.glMultiDrawArraysIndirect = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMultiDrawElementsIndirect");
        this.glMultiDrawElementsIndirect = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_multisample_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glSampleCoverageARB");
        this.glSampleCoverageARB = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_multitexture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glClientActiveTextureARB");
        this.glClientActiveTextureARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glActiveTextureARB");
        this.glActiveTextureARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glMultiTexCoord1fARB");
        this.glMultiTexCoord1fARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glMultiTexCoord1dARB");
        this.glMultiTexCoord1dARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glMultiTexCoord1iARB");
        this.glMultiTexCoord1iARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glMultiTexCoord1sARB");
        this.glMultiTexCoord1sARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glMultiTexCoord2fARB");
        this.glMultiTexCoord2fARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glMultiTexCoord2dARB");
        this.glMultiTexCoord2dARB = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glMultiTexCoord2iARB");
        this.glMultiTexCoord2iARB = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glMultiTexCoord2sARB");
        this.glMultiTexCoord2sARB = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glMultiTexCoord3fARB");
        this.glMultiTexCoord3fARB = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glMultiTexCoord3dARB");
        this.glMultiTexCoord3dARB = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glMultiTexCoord3iARB");
        this.glMultiTexCoord3iARB = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glMultiTexCoord3sARB");
        this.glMultiTexCoord3sARB = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glMultiTexCoord4fARB");
        this.glMultiTexCoord4fARB = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glMultiTexCoord4dARB");
        this.glMultiTexCoord4dARB = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glMultiTexCoord4iARB");
        this.glMultiTexCoord4iARB = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glMultiTexCoord4sARB");
        this.glMultiTexCoord4sARB = functionAddress18;
        return z17 & (functionAddress18 != 0);
    }

    private boolean ARB_occlusion_query_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGenQueriesARB");
        this.glGenQueriesARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteQueriesARB");
        this.glDeleteQueriesARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glIsQueryARB");
        this.glIsQueryARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBeginQueryARB");
        this.glBeginQueryARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glEndQueryARB");
        this.glEndQueryARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetQueryivARB");
        this.glGetQueryivARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetQueryObjectivARB");
        this.glGetQueryObjectivARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetQueryObjectuivARB");
        this.glGetQueryObjectuivARB = functionAddress8;
        return z7 & (functionAddress8 != 0);
    }

    private boolean ARB_point_parameters_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPointParameterfARB");
        this.glPointParameterfARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glPointParameterfvARB");
        this.glPointParameterfvARB = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_program_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProgramStringARB");
        this.glProgramStringARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindProgramARB");
        this.glBindProgramARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDeleteProgramsARB");
        this.glDeleteProgramsARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGenProgramsARB");
        this.glGenProgramsARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glProgramEnvParameter4fARB");
        this.glProgramEnvParameter4fARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glProgramEnvParameter4dARB");
        this.glProgramEnvParameter4dARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glProgramEnvParameter4fvARB");
        this.glProgramEnvParameter4fvARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glProgramEnvParameter4dvARB");
        this.glProgramEnvParameter4dvARB = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glProgramLocalParameter4fARB");
        this.glProgramLocalParameter4fARB = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glProgramLocalParameter4dARB");
        this.glProgramLocalParameter4dARB = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glProgramLocalParameter4fvARB");
        this.glProgramLocalParameter4fvARB = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glProgramLocalParameter4dvARB");
        this.glProgramLocalParameter4dvARB = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glGetProgramEnvParameterfvARB");
        this.glGetProgramEnvParameterfvARB = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glGetProgramEnvParameterdvARB");
        this.glGetProgramEnvParameterdvARB = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glGetProgramLocalParameterfvARB");
        this.glGetProgramLocalParameterfvARB = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glGetProgramLocalParameterdvARB");
        this.glGetProgramLocalParameterdvARB = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glGetProgramivARB");
        this.glGetProgramivARB = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glGetProgramStringARB");
        this.glGetProgramStringARB = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glIsProgramARB");
        this.glIsProgramARB = functionAddress19;
        return z18 & (functionAddress19 != 0);
    }

    private boolean ARB_program_interface_query_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetProgramInterfaceiv");
        this.glGetProgramInterfaceiv = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetProgramResourceIndex");
        this.glGetProgramResourceIndex = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetProgramResourceName");
        this.glGetProgramResourceName = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetProgramResourceiv");
        this.glGetProgramResourceiv = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetProgramResourceLocation");
        this.glGetProgramResourceLocation = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetProgramResourceLocationIndex");
        this.glGetProgramResourceLocationIndex = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean ARB_provoking_vertex_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProvokingVertex");
        this.glProvokingVertex = functionAddress;
        return functionAddress != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_robustness_initNativeFunctionAddresses(boolean r8, java.util.Set<java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_robustness_initNativeFunctionAddresses(boolean, java.util.Set):boolean");
    }

    private boolean ARB_sample_shading_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMinSampleShadingARB");
        this.glMinSampleShadingARB = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_sampler_objects_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGenSamplers");
        this.glGenSamplers = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteSamplers");
        this.glDeleteSamplers = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glIsSampler");
        this.glIsSampler = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBindSampler");
        this.glBindSampler = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glSamplerParameteri");
        this.glSamplerParameteri = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glSamplerParameterf");
        this.glSamplerParameterf = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glSamplerParameteriv");
        this.glSamplerParameteriv = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glSamplerParameterfv");
        this.glSamplerParameterfv = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glSamplerParameterIiv");
        this.glSamplerParameterIiv = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glSamplerParameterIuiv");
        this.glSamplerParameterIuiv = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetSamplerParameteriv");
        this.glGetSamplerParameteriv = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glGetSamplerParameterfv");
        this.glGetSamplerParameterfv = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glGetSamplerParameterIiv");
        this.glGetSamplerParameterIiv = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glGetSamplerParameterIuiv");
        this.glGetSamplerParameterIuiv = functionAddress14;
        return z13 & (functionAddress14 != 0);
    }

    private boolean ARB_separate_shader_objects_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glUseProgramStages");
        this.glUseProgramStages = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glActiveShaderProgram");
        this.glActiveShaderProgram = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glCreateShaderProgramv");
        this.glCreateShaderProgramv = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBindProgramPipeline");
        this.glBindProgramPipeline = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glDeleteProgramPipelines");
        this.glDeleteProgramPipelines = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGenProgramPipelines");
        this.glGenProgramPipelines = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glIsProgramPipeline");
        this.glIsProgramPipeline = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glProgramParameteri");
        this.glProgramParameteri = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetProgramPipelineiv");
        this.glGetProgramPipelineiv = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glProgramUniform1i");
        this.glProgramUniform1i = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glProgramUniform2i");
        this.glProgramUniform2i = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glProgramUniform3i");
        this.glProgramUniform3i = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glProgramUniform4i");
        this.glProgramUniform4i = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glProgramUniform1f");
        this.glProgramUniform1f = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glProgramUniform2f");
        this.glProgramUniform2f = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glProgramUniform3f");
        this.glProgramUniform3f = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glProgramUniform4f");
        this.glProgramUniform4f = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glProgramUniform1d");
        this.glProgramUniform1d = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glProgramUniform2d");
        this.glProgramUniform2d = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glProgramUniform3d");
        this.glProgramUniform3d = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glProgramUniform4d");
        this.glProgramUniform4d = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glProgramUniform1iv");
        this.glProgramUniform1iv = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glProgramUniform2iv");
        this.glProgramUniform2iv = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glProgramUniform3iv");
        this.glProgramUniform3iv = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glProgramUniform4iv");
        this.glProgramUniform4iv = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glProgramUniform1fv");
        this.glProgramUniform1fv = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glProgramUniform2fv");
        this.glProgramUniform2fv = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glProgramUniform3fv");
        this.glProgramUniform3fv = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glProgramUniform4fv");
        this.glProgramUniform4fv = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glProgramUniform1dv");
        this.glProgramUniform1dv = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glProgramUniform2dv");
        this.glProgramUniform2dv = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glProgramUniform3dv");
        this.glProgramUniform3dv = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glProgramUniform4dv");
        this.glProgramUniform4dv = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glProgramUniform1ui");
        this.glProgramUniform1ui = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glProgramUniform2ui");
        this.glProgramUniform2ui = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glProgramUniform3ui");
        this.glProgramUniform3ui = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glProgramUniform4ui");
        this.glProgramUniform4ui = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glProgramUniform1uiv");
        this.glProgramUniform1uiv = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glProgramUniform2uiv");
        this.glProgramUniform2uiv = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glProgramUniform3uiv");
        this.glProgramUniform3uiv = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glProgramUniform4uiv");
        this.glProgramUniform4uiv = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glProgramUniformMatrix2fv");
        this.glProgramUniformMatrix2fv = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glProgramUniformMatrix3fv");
        this.glProgramUniformMatrix3fv = functionAddress43;
        boolean z43 = z42 & (functionAddress43 != 0);
        long functionAddress44 = GLContext.getFunctionAddress("glProgramUniformMatrix4fv");
        this.glProgramUniformMatrix4fv = functionAddress44;
        boolean z44 = z43 & (functionAddress44 != 0);
        long functionAddress45 = GLContext.getFunctionAddress("glProgramUniformMatrix2dv");
        this.glProgramUniformMatrix2dv = functionAddress45;
        boolean z45 = z44 & (functionAddress45 != 0);
        long functionAddress46 = GLContext.getFunctionAddress("glProgramUniformMatrix3dv");
        this.glProgramUniformMatrix3dv = functionAddress46;
        boolean z46 = z45 & (functionAddress46 != 0);
        long functionAddress47 = GLContext.getFunctionAddress("glProgramUniformMatrix4dv");
        this.glProgramUniformMatrix4dv = functionAddress47;
        boolean z47 = z46 & (functionAddress47 != 0);
        long functionAddress48 = GLContext.getFunctionAddress("glProgramUniformMatrix2x3fv");
        this.glProgramUniformMatrix2x3fv = functionAddress48;
        boolean z48 = z47 & (functionAddress48 != 0);
        long functionAddress49 = GLContext.getFunctionAddress("glProgramUniformMatrix3x2fv");
        this.glProgramUniformMatrix3x2fv = functionAddress49;
        boolean z49 = z48 & (functionAddress49 != 0);
        long functionAddress50 = GLContext.getFunctionAddress("glProgramUniformMatrix2x4fv");
        this.glProgramUniformMatrix2x4fv = functionAddress50;
        boolean z50 = z49 & (functionAddress50 != 0);
        long functionAddress51 = GLContext.getFunctionAddress("glProgramUniformMatrix4x2fv");
        this.glProgramUniformMatrix4x2fv = functionAddress51;
        boolean z51 = z50 & (functionAddress51 != 0);
        long functionAddress52 = GLContext.getFunctionAddress("glProgramUniformMatrix3x4fv");
        this.glProgramUniformMatrix3x4fv = functionAddress52;
        boolean z52 = z51 & (functionAddress52 != 0);
        long functionAddress53 = GLContext.getFunctionAddress("glProgramUniformMatrix4x3fv");
        this.glProgramUniformMatrix4x3fv = functionAddress53;
        boolean z53 = z52 & (functionAddress53 != 0);
        long functionAddress54 = GLContext.getFunctionAddress("glProgramUniformMatrix2x3dv");
        this.glProgramUniformMatrix2x3dv = functionAddress54;
        boolean z54 = z53 & (functionAddress54 != 0);
        long functionAddress55 = GLContext.getFunctionAddress("glProgramUniformMatrix3x2dv");
        this.glProgramUniformMatrix3x2dv = functionAddress55;
        boolean z55 = z54 & (functionAddress55 != 0);
        long functionAddress56 = GLContext.getFunctionAddress("glProgramUniformMatrix2x4dv");
        this.glProgramUniformMatrix2x4dv = functionAddress56;
        boolean z56 = z55 & (functionAddress56 != 0);
        long functionAddress57 = GLContext.getFunctionAddress("glProgramUniformMatrix4x2dv");
        this.glProgramUniformMatrix4x2dv = functionAddress57;
        boolean z57 = z56 & (functionAddress57 != 0);
        long functionAddress58 = GLContext.getFunctionAddress("glProgramUniformMatrix3x4dv");
        this.glProgramUniformMatrix3x4dv = functionAddress58;
        boolean z58 = z57 & (functionAddress58 != 0);
        long functionAddress59 = GLContext.getFunctionAddress("glProgramUniformMatrix4x3dv");
        this.glProgramUniformMatrix4x3dv = functionAddress59;
        boolean z59 = z58 & (functionAddress59 != 0);
        long functionAddress60 = GLContext.getFunctionAddress("glValidateProgramPipeline");
        this.glValidateProgramPipeline = functionAddress60;
        boolean z60 = z59 & (functionAddress60 != 0);
        long functionAddress61 = GLContext.getFunctionAddress("glGetProgramPipelineInfoLog");
        this.glGetProgramPipelineInfoLog = functionAddress61;
        return z60 & (functionAddress61 != 0);
    }

    private boolean ARB_shader_atomic_counters_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetActiveAtomicCounterBufferiv");
        this.glGetActiveAtomicCounterBufferiv = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_shader_image_load_store_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindImageTexture");
        this.glBindImageTexture = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMemoryBarrier");
        this.glMemoryBarrier = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_shader_objects_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDeleteObjectARB");
        this.glDeleteObjectARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetHandleARB");
        this.glGetHandleARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDetachObjectARB");
        this.glDetachObjectARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glCreateShaderObjectARB");
        this.glCreateShaderObjectARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glShaderSourceARB");
        this.glShaderSourceARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glCompileShaderARB");
        this.glCompileShaderARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glCreateProgramObjectARB");
        this.glCreateProgramObjectARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glAttachObjectARB");
        this.glAttachObjectARB = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glLinkProgramARB");
        this.glLinkProgramARB = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glUseProgramObjectARB");
        this.glUseProgramObjectARB = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glValidateProgramARB");
        this.glValidateProgramARB = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glUniform1fARB");
        this.glUniform1fARB = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glUniform2fARB");
        this.glUniform2fARB = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glUniform3fARB");
        this.glUniform3fARB = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glUniform4fARB");
        this.glUniform4fARB = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glUniform1iARB");
        this.glUniform1iARB = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glUniform2iARB");
        this.glUniform2iARB = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glUniform3iARB");
        this.glUniform3iARB = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glUniform4iARB");
        this.glUniform4iARB = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glUniform1fvARB");
        this.glUniform1fvARB = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glUniform2fvARB");
        this.glUniform2fvARB = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glUniform3fvARB");
        this.glUniform3fvARB = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glUniform4fvARB");
        this.glUniform4fvARB = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glUniform1ivARB");
        this.glUniform1ivARB = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glUniform2ivARB");
        this.glUniform2ivARB = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glUniform3ivARB");
        this.glUniform3ivARB = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glUniform4ivARB");
        this.glUniform4ivARB = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glUniformMatrix2fvARB");
        this.glUniformMatrix2fvARB = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glUniformMatrix3fvARB");
        this.glUniformMatrix3fvARB = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glUniformMatrix4fvARB");
        this.glUniformMatrix4fvARB = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glGetObjectParameterfvARB");
        this.glGetObjectParameterfvARB = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glGetObjectParameterivARB");
        this.glGetObjectParameterivARB = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glGetInfoLogARB");
        this.glGetInfoLogARB = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glGetAttachedObjectsARB");
        this.glGetAttachedObjectsARB = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glGetUniformLocationARB");
        this.glGetUniformLocationARB = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glGetActiveUniformARB");
        this.glGetActiveUniformARB = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glGetUniformfvARB");
        this.glGetUniformfvARB = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glGetUniformivARB");
        this.glGetUniformivARB = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glGetShaderSourceARB");
        this.glGetShaderSourceARB = functionAddress39;
        return z38 & (functionAddress39 != 0);
    }

    private boolean ARB_shader_storage_buffer_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glShaderStorageBlockBinding");
        this.glShaderStorageBlockBinding = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_shader_subroutine_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetSubroutineUniformLocation");
        this.glGetSubroutineUniformLocation = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetSubroutineIndex");
        this.glGetSubroutineIndex = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetActiveSubroutineUniformiv");
        this.glGetActiveSubroutineUniformiv = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetActiveSubroutineUniformName");
        this.glGetActiveSubroutineUniformName = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetActiveSubroutineName");
        this.glGetActiveSubroutineName = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glUniformSubroutinesuiv");
        this.glUniformSubroutinesuiv = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetUniformSubroutineuiv");
        this.glGetUniformSubroutineuiv = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetProgramStageiv");
        this.glGetProgramStageiv = functionAddress8;
        return z7 & (functionAddress8 != 0);
    }

    private boolean ARB_shading_language_include_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glNamedStringARB");
        this.glNamedStringARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteNamedStringARB");
        this.glDeleteNamedStringARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glCompileShaderIncludeARB");
        this.glCompileShaderIncludeARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glIsNamedStringARB");
        this.glIsNamedStringARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetNamedStringARB");
        this.glGetNamedStringARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetNamedStringivARB");
        this.glGetNamedStringivARB = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean ARB_sparse_buffer_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBufferPageCommitmentARB");
        this.glBufferPageCommitmentARB = functionAddress;
        return functionAddress != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_sparse_texture_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            r7 = this;
            r0 = r7
            java.lang.String r1 = "glTexPageCommitmentARB"
            long r1 = org.lwjgl.opengl.GLContext.getFunctionAddress(r1)
            r2 = r1; r1 = r0; r0 = r2; 
            r1.glTexPageCommitmentARB = r2
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L30
            r1 = r7
            java.lang.String r2 = "glTexturePageCommitmentEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glTexturePageCommitmentEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L34
        L30:
            r1 = 1
            goto L35
        L34:
            r1 = 0
        L35:
            r0 = r0 & r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_sparse_texture_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean ARB_sync_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glFenceSync");
        this.glFenceSync = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glIsSync");
        this.glIsSync = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDeleteSync");
        this.glDeleteSync = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glClientWaitSync");
        this.glClientWaitSync = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glWaitSync");
        this.glWaitSync = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetInteger64v");
        this.glGetInteger64v = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetSynciv");
        this.glGetSynciv = functionAddress7;
        return z6 & (functionAddress7 != 0);
    }

    private boolean ARB_tessellation_shader_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPatchParameteri");
        this.glPatchParameteri = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glPatchParameterfv");
        this.glPatchParameterfv = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_texture_barrier_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTextureBarrier");
        this.glTextureBarrier = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_texture_buffer_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTexBufferARB");
        this.glTexBufferARB = functionAddress;
        return functionAddress != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_texture_buffer_range_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            r7 = this;
            r0 = r7
            java.lang.String r1 = "glTexBufferRange"
            long r1 = org.lwjgl.opengl.GLContext.getFunctionAddress(r1)
            r2 = r1; r1 = r0; r0 = r2; 
            r1.glTexBufferRange = r2
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L30
            r1 = r7
            java.lang.String r2 = "glTextureBufferRangeEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glTextureBufferRangeEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L34
        L30:
            r1 = 1
            goto L35
        L34:
            r1 = 0
        L35:
            r0 = r0 & r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_texture_buffer_range_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean ARB_texture_compression_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCompressedTexImage1DARB");
        this.glCompressedTexImage1DARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glCompressedTexImage2DARB");
        this.glCompressedTexImage2DARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glCompressedTexImage3DARB");
        this.glCompressedTexImage3DARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glCompressedTexSubImage1DARB");
        this.glCompressedTexSubImage1DARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glCompressedTexSubImage2DARB");
        this.glCompressedTexSubImage2DARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glCompressedTexSubImage3DARB");
        this.glCompressedTexSubImage3DARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetCompressedTexImageARB");
        this.glGetCompressedTexImageARB = functionAddress7;
        return z6 & (functionAddress7 != 0);
    }

    private boolean ARB_texture_multisample_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTexImage2DMultisample");
        this.glTexImage2DMultisample = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glTexImage3DMultisample");
        this.glTexImage3DMultisample = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetMultisamplefv");
        this.glGetMultisamplefv = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glSampleMaski");
        this.glSampleMaski = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_texture_storage_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_texture_storage_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_texture_storage_multisample_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            r7 = this;
            r0 = r7
            java.lang.String r1 = "glTexStorage2DMultisample"
            long r1 = org.lwjgl.opengl.GLContext.getFunctionAddress(r1)
            r2 = r1; r1 = r0; r0 = r2; 
            r1.glTexStorage2DMultisample = r2
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            r1 = r7
            java.lang.String r2 = "glTexStorage3DMultisample"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glTexStorage3DMultisample = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L29
            r1 = 1
            goto L2a
        L29:
            r1 = 0
        L2a:
            r0 = r0 & r1
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L46
            r1 = r7
            java.lang.String r2 = "glTextureStorage2DMultisampleEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glTextureStorage2DMultisampleEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L4a
        L46:
            r1 = 1
            goto L4b
        L4a:
            r1 = 0
        L4b:
            r0 = r0 & r1
            r1 = r8
            java.lang.String r2 = "GL_EXT_direct_state_access"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L67
            r1 = r7
            java.lang.String r2 = "glTextureStorage3DMultisampleEXT"
            long r2 = org.lwjgl.opengl.GLContext.getFunctionAddress(r2)
            r3 = r2; r2 = r1; r1 = r3; 
            r2.glTextureStorage3DMultisampleEXT = r3
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L6b
        L67:
            r1 = 1
            goto L6c
        L6b:
            r1 = 0
        L6c:
            r0 = r0 & r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_texture_storage_multisample_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean ARB_texture_view_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTextureView");
        this.glTextureView = functionAddress;
        return functionAddress != 0;
    }

    private boolean ARB_timer_query_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glQueryCounter");
        this.glQueryCounter = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetQueryObjecti64v");
        this.glGetQueryObjecti64v = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetQueryObjectui64v");
        this.glGetQueryObjectui64v = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean ARB_transform_feedback2_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindTransformFeedback");
        this.glBindTransformFeedback = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteTransformFeedbacks");
        this.glDeleteTransformFeedbacks = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGenTransformFeedbacks");
        this.glGenTransformFeedbacks = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glIsTransformFeedback");
        this.glIsTransformFeedback = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glPauseTransformFeedback");
        this.glPauseTransformFeedback = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glResumeTransformFeedback");
        this.glResumeTransformFeedback = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glDrawTransformFeedback");
        this.glDrawTransformFeedback = functionAddress7;
        return z6 & (functionAddress7 != 0);
    }

    private boolean ARB_transform_feedback3_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawTransformFeedbackStream");
        this.glDrawTransformFeedbackStream = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBeginQueryIndexed");
        this.glBeginQueryIndexed = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glEndQueryIndexed");
        this.glEndQueryIndexed = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetQueryIndexediv");
        this.glGetQueryIndexediv = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean ARB_transform_feedback_instanced_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawTransformFeedbackInstanced");
        this.glDrawTransformFeedbackInstanced = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawTransformFeedbackStreamInstanced");
        this.glDrawTransformFeedbackStreamInstanced = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_transpose_matrix_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glLoadTransposeMatrixfARB");
        this.glLoadTransposeMatrixfARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMultTransposeMatrixfARB");
        this.glMultTransposeMatrixfARB = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ARB_uniform_buffer_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetUniformIndices");
        this.glGetUniformIndices = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetActiveUniformsiv");
        this.glGetActiveUniformsiv = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetActiveUniformName");
        this.glGetActiveUniformName = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetUniformBlockIndex");
        this.glGetUniformBlockIndex = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetActiveUniformBlockiv");
        this.glGetActiveUniformBlockiv = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetActiveUniformBlockName");
        this.glGetActiveUniformBlockName = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glBindBufferRange");
        this.glBindBufferRange = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glBindBufferBase");
        this.glBindBufferBase = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetIntegeri_v");
        this.glGetIntegeri_v = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glUniformBlockBinding");
        this.glUniformBlockBinding = functionAddress10;
        return z9 & (functionAddress10 != 0);
    }

    private boolean ARB_vertex_array_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindVertexArray");
        this.glBindVertexArray = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteVertexArrays");
        this.glDeleteVertexArrays = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGenVertexArrays");
        this.glGenVertexArrays = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glIsVertexArray");
        this.glIsVertexArray = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_vertex_attrib_64bit_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_vertex_attrib_64bit_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean ARB_vertex_attrib_binding_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindVertexBuffer");
        this.glBindVertexBuffer = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glVertexAttribFormat");
        this.glVertexAttribFormat = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glVertexAttribIFormat");
        this.glVertexAttribIFormat = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glVertexAttribLFormat");
        this.glVertexAttribLFormat = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glVertexAttribBinding");
        this.glVertexAttribBinding = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glVertexBindingDivisor");
        this.glVertexBindingDivisor = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean ARB_vertex_blend_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glWeightbvARB");
        this.glWeightbvARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glWeightsvARB");
        this.glWeightsvARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glWeightivARB");
        this.glWeightivARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glWeightfvARB");
        this.glWeightfvARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glWeightdvARB");
        this.glWeightdvARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glWeightubvARB");
        this.glWeightubvARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glWeightusvARB");
        this.glWeightusvARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glWeightuivARB");
        this.glWeightuivARB = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glWeightPointerARB");
        this.glWeightPointerARB = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVertexBlendARB");
        this.glVertexBlendARB = functionAddress10;
        return z9 & (functionAddress10 != 0);
    }

    private boolean ARB_vertex_program_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexAttrib1sARB");
        this.glVertexAttrib1sARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glVertexAttrib1fARB");
        this.glVertexAttrib1fARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glVertexAttrib1dARB");
        this.glVertexAttrib1dARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glVertexAttrib2sARB");
        this.glVertexAttrib2sARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glVertexAttrib2fARB");
        this.glVertexAttrib2fARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glVertexAttrib2dARB");
        this.glVertexAttrib2dARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glVertexAttrib3sARB");
        this.glVertexAttrib3sARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glVertexAttrib3fARB");
        this.glVertexAttrib3fARB = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glVertexAttrib3dARB");
        this.glVertexAttrib3dARB = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVertexAttrib4sARB");
        this.glVertexAttrib4sARB = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glVertexAttrib4fARB");
        this.glVertexAttrib4fARB = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glVertexAttrib4dARB");
        this.glVertexAttrib4dARB = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glVertexAttrib4NubARB");
        this.glVertexAttrib4NubARB = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glVertexAttribPointerARB");
        this.glVertexAttribPointerARB = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glEnableVertexAttribArrayARB");
        this.glEnableVertexAttribArrayARB = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glDisableVertexAttribArrayARB");
        this.glDisableVertexAttribArrayARB = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glGetVertexAttribfvARB");
        this.glGetVertexAttribfvARB = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glGetVertexAttribdvARB");
        this.glGetVertexAttribdvARB = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glGetVertexAttribivARB");
        this.glGetVertexAttribivARB = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glGetVertexAttribPointervARB");
        this.glGetVertexAttribPointervARB = functionAddress20;
        return z19 & (functionAddress20 != 0);
    }

    private boolean ARB_vertex_shader_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexAttrib1sARB");
        this.glVertexAttrib1sARB = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glVertexAttrib1fARB");
        this.glVertexAttrib1fARB = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glVertexAttrib1dARB");
        this.glVertexAttrib1dARB = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glVertexAttrib2sARB");
        this.glVertexAttrib2sARB = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glVertexAttrib2fARB");
        this.glVertexAttrib2fARB = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glVertexAttrib2dARB");
        this.glVertexAttrib2dARB = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glVertexAttrib3sARB");
        this.glVertexAttrib3sARB = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glVertexAttrib3fARB");
        this.glVertexAttrib3fARB = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glVertexAttrib3dARB");
        this.glVertexAttrib3dARB = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVertexAttrib4sARB");
        this.glVertexAttrib4sARB = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glVertexAttrib4fARB");
        this.glVertexAttrib4fARB = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glVertexAttrib4dARB");
        this.glVertexAttrib4dARB = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glVertexAttrib4NubARB");
        this.glVertexAttrib4NubARB = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glVertexAttribPointerARB");
        this.glVertexAttribPointerARB = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glEnableVertexAttribArrayARB");
        this.glEnableVertexAttribArrayARB = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glDisableVertexAttribArrayARB");
        this.glDisableVertexAttribArrayARB = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glBindAttribLocationARB");
        this.glBindAttribLocationARB = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glGetActiveAttribARB");
        this.glGetActiveAttribARB = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glGetAttribLocationARB");
        this.glGetAttribLocationARB = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glGetVertexAttribfvARB");
        this.glGetVertexAttribfvARB = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glGetVertexAttribdvARB");
        this.glGetVertexAttribdvARB = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glGetVertexAttribivARB");
        this.glGetVertexAttribivARB = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glGetVertexAttribPointervARB");
        this.glGetVertexAttribPointervARB = functionAddress23;
        return z22 & (functionAddress23 != 0);
    }

    private boolean ARB_vertex_type_2_10_10_10_rev_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexP2ui");
        this.glVertexP2ui = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glVertexP3ui");
        this.glVertexP3ui = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glVertexP4ui");
        this.glVertexP4ui = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glVertexP2uiv");
        this.glVertexP2uiv = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glVertexP3uiv");
        this.glVertexP3uiv = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glVertexP4uiv");
        this.glVertexP4uiv = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glTexCoordP1ui");
        this.glTexCoordP1ui = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glTexCoordP2ui");
        this.glTexCoordP2ui = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glTexCoordP3ui");
        this.glTexCoordP3ui = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glTexCoordP4ui");
        this.glTexCoordP4ui = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glTexCoordP1uiv");
        this.glTexCoordP1uiv = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glTexCoordP2uiv");
        this.glTexCoordP2uiv = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glTexCoordP3uiv");
        this.glTexCoordP3uiv = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glTexCoordP4uiv");
        this.glTexCoordP4uiv = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glMultiTexCoordP1ui");
        this.glMultiTexCoordP1ui = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glMultiTexCoordP2ui");
        this.glMultiTexCoordP2ui = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glMultiTexCoordP3ui");
        this.glMultiTexCoordP3ui = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glMultiTexCoordP4ui");
        this.glMultiTexCoordP4ui = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glMultiTexCoordP1uiv");
        this.glMultiTexCoordP1uiv = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glMultiTexCoordP2uiv");
        this.glMultiTexCoordP2uiv = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glMultiTexCoordP3uiv");
        this.glMultiTexCoordP3uiv = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glMultiTexCoordP4uiv");
        this.glMultiTexCoordP4uiv = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glNormalP3ui");
        this.glNormalP3ui = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glNormalP3uiv");
        this.glNormalP3uiv = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glColorP3ui");
        this.glColorP3ui = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glColorP4ui");
        this.glColorP4ui = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glColorP3uiv");
        this.glColorP3uiv = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glColorP4uiv");
        this.glColorP4uiv = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glSecondaryColorP3ui");
        this.glSecondaryColorP3ui = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glSecondaryColorP3uiv");
        this.glSecondaryColorP3uiv = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glVertexAttribP1ui");
        this.glVertexAttribP1ui = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glVertexAttribP2ui");
        this.glVertexAttribP2ui = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glVertexAttribP3ui");
        this.glVertexAttribP3ui = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glVertexAttribP4ui");
        this.glVertexAttribP4ui = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glVertexAttribP1uiv");
        this.glVertexAttribP1uiv = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glVertexAttribP2uiv");
        this.glVertexAttribP2uiv = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glVertexAttribP3uiv");
        this.glVertexAttribP3uiv = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glVertexAttribP4uiv");
        this.glVertexAttribP4uiv = functionAddress38;
        return z37 & (functionAddress38 != 0);
    }

    private boolean ARB_viewport_array_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glViewportArrayv");
        this.glViewportArrayv = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glViewportIndexedf");
        this.glViewportIndexedf = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glViewportIndexedfv");
        this.glViewportIndexedfv = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glScissorArrayv");
        this.glScissorArrayv = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glScissorIndexed");
        this.glScissorIndexed = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glScissorIndexedv");
        this.glScissorIndexedv = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glDepthRangeArrayv");
        this.glDepthRangeArrayv = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glDepthRangeIndexed");
        this.glDepthRangeIndexed = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetFloati_v");
        this.glGetFloati_v = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glGetDoublei_v");
        this.glGetDoublei_v = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT");
        this.glGetIntegerIndexedvEXT = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glEnableIndexedEXT");
        this.glEnableIndexedEXT = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glDisableIndexedEXT");
        this.glDisableIndexedEXT = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glIsEnabledIndexedEXT");
        this.glIsEnabledIndexedEXT = functionAddress14;
        return z13 & (functionAddress14 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ARB_window_pos_initNativeFunctionAddresses(boolean r8) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.ARB_window_pos_initNativeFunctionAddresses(boolean):boolean");
    }

    private boolean ATI_draw_buffers_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawBuffersATI");
        this.glDrawBuffersATI = functionAddress;
        return functionAddress != 0;
    }

    private boolean ATI_element_array_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glElementPointerATI");
        this.glElementPointerATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawElementArrayATI");
        this.glDrawElementArrayATI = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDrawRangeElementArrayATI");
        this.glDrawRangeElementArrayATI = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean ATI_envmap_bumpmap_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTexBumpParameterfvATI");
        this.glTexBumpParameterfvATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glTexBumpParameterivATI");
        this.glTexBumpParameterivATI = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetTexBumpParameterfvATI");
        this.glGetTexBumpParameterfvATI = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetTexBumpParameterivATI");
        this.glGetTexBumpParameterivATI = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean ATI_fragment_shader_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGenFragmentShadersATI");
        this.glGenFragmentShadersATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindFragmentShaderATI");
        this.glBindFragmentShaderATI = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDeleteFragmentShaderATI");
        this.glDeleteFragmentShaderATI = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBeginFragmentShaderATI");
        this.glBeginFragmentShaderATI = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glEndFragmentShaderATI");
        this.glEndFragmentShaderATI = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glPassTexCoordATI");
        this.glPassTexCoordATI = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glSampleMapATI");
        this.glSampleMapATI = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glColorFragmentOp1ATI");
        this.glColorFragmentOp1ATI = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glColorFragmentOp2ATI");
        this.glColorFragmentOp2ATI = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glColorFragmentOp3ATI");
        this.glColorFragmentOp3ATI = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glAlphaFragmentOp1ATI");
        this.glAlphaFragmentOp1ATI = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glAlphaFragmentOp2ATI");
        this.glAlphaFragmentOp2ATI = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glAlphaFragmentOp3ATI");
        this.glAlphaFragmentOp3ATI = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glSetFragmentShaderConstantATI");
        this.glSetFragmentShaderConstantATI = functionAddress14;
        return z13 & (functionAddress14 != 0);
    }

    private boolean ATI_map_object_buffer_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMapObjectBufferATI");
        this.glMapObjectBufferATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glUnmapObjectBufferATI");
        this.glUnmapObjectBufferATI = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ATI_pn_triangles_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPNTrianglesfATI");
        this.glPNTrianglesfATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glPNTrianglesiATI");
        this.glPNTrianglesiATI = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ATI_separate_stencil_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glStencilOpSeparateATI");
        this.glStencilOpSeparateATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glStencilFuncSeparateATI");
        this.glStencilFuncSeparateATI = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean ATI_vertex_array_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glNewObjectBufferATI");
        this.glNewObjectBufferATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glIsObjectBufferATI");
        this.glIsObjectBufferATI = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glUpdateObjectBufferATI");
        this.glUpdateObjectBufferATI = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetObjectBufferfvATI");
        this.glGetObjectBufferfvATI = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetObjectBufferivATI");
        this.glGetObjectBufferivATI = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glFreeObjectBufferATI");
        this.glFreeObjectBufferATI = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glArrayObjectATI");
        this.glArrayObjectATI = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetArrayObjectfvATI");
        this.glGetArrayObjectfvATI = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetArrayObjectivATI");
        this.glGetArrayObjectivATI = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVariantArrayObjectATI");
        this.glVariantArrayObjectATI = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetVariantArrayObjectfvATI");
        this.glGetVariantArrayObjectfvATI = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glGetVariantArrayObjectivATI");
        this.glGetVariantArrayObjectivATI = functionAddress12;
        return z11 & (functionAddress12 != 0);
    }

    private boolean ATI_vertex_attrib_array_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexAttribArrayObjectATI");
        this.glVertexAttribArrayObjectATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetVertexAttribArrayObjectfvATI");
        this.glGetVertexAttribArrayObjectfvATI = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetVertexAttribArrayObjectivATI");
        this.glGetVertexAttribArrayObjectivATI = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean ATI_vertex_streams_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexStream2fATI");
        this.glVertexStream2fATI = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glVertexStream2dATI");
        this.glVertexStream2dATI = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glVertexStream2iATI");
        this.glVertexStream2iATI = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glVertexStream2sATI");
        this.glVertexStream2sATI = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glVertexStream3fATI");
        this.glVertexStream3fATI = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glVertexStream3dATI");
        this.glVertexStream3dATI = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glVertexStream3iATI");
        this.glVertexStream3iATI = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glVertexStream3sATI");
        this.glVertexStream3sATI = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glVertexStream4fATI");
        this.glVertexStream4fATI = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVertexStream4dATI");
        this.glVertexStream4dATI = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glVertexStream4iATI");
        this.glVertexStream4iATI = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glVertexStream4sATI");
        this.glVertexStream4sATI = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glNormalStream3bATI");
        this.glNormalStream3bATI = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glNormalStream3fATI");
        this.glNormalStream3fATI = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glNormalStream3dATI");
        this.glNormalStream3dATI = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glNormalStream3iATI");
        this.glNormalStream3iATI = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glNormalStream3sATI");
        this.glNormalStream3sATI = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glClientActiveVertexStreamATI");
        this.glClientActiveVertexStreamATI = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glVertexBlendEnvfATI");
        this.glVertexBlendEnvfATI = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glVertexBlendEnviATI");
        this.glVertexBlendEnviATI = functionAddress20;
        return z19 & (functionAddress20 != 0);
    }

    private boolean EXT_bindable_uniform_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glUniformBufferEXT");
        this.glUniformBufferEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetUniformBufferSizeEXT");
        this.glGetUniformBufferSizeEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetUniformOffsetEXT");
        this.glGetUniformOffsetEXT = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean EXT_blend_color_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlendColorEXT");
        this.glBlendColorEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_blend_equation_separate_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlendEquationSeparateEXT");
        this.glBlendEquationSeparateEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_blend_func_separate_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlendFuncSeparateEXT");
        this.glBlendFuncSeparateEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_blend_minmax_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlendEquationEXT");
        this.glBlendEquationEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_compiled_vertex_array_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glLockArraysEXT");
        this.glLockArraysEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glUnlockArraysEXT");
        this.glUnlockArraysEXT = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean EXT_depth_bounds_test_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDepthBoundsEXT");
        this.glDepthBoundsEXT = functionAddress;
        return functionAddress != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:1002:0x1517  */
    /* JADX WARN: Removed duplicated region for block: B:1008:0x1539  */
    /* JADX WARN: Removed duplicated region for block: B:1014:0x155b  */
    /* JADX WARN: Removed duplicated region for block: B:1020:0x157d  */
    /* JADX WARN: Removed duplicated region for block: B:1026:0x159f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:1032:0x15c1  */
    /* JADX WARN: Removed duplicated region for block: B:1038:0x15e3  */
    /* JADX WARN: Removed duplicated region for block: B:1044:0x1605  */
    /* JADX WARN: Removed duplicated region for block: B:1050:0x1627  */
    /* JADX WARN: Removed duplicated region for block: B:1058:0x1655  */
    /* JADX WARN: Removed duplicated region for block: B:1066:0x1683  */
    /* JADX WARN: Removed duplicated region for block: B:1074:0x16b1  */
    /* JADX WARN: Removed duplicated region for block: B:1080:0x16d3  */
    /* JADX WARN: Removed duplicated region for block: B:1088:0x1701  */
    /* JADX WARN: Removed duplicated region for block: B:1096:0x172f  */
    /* JADX WARN: Removed duplicated region for block: B:1104:0x175d  */
    /* JADX WARN: Removed duplicated region for block: B:1112:0x178b  */
    /* JADX WARN: Removed duplicated region for block: B:1120:0x17b9  */
    /* JADX WARN: Removed duplicated region for block: B:1128:0x17e7  */
    /* JADX WARN: Removed duplicated region for block: B:1136:0x1815  */
    /* JADX WARN: Removed duplicated region for block: B:1144:0x1843  */
    /* JADX WARN: Removed duplicated region for block: B:1152:0x1871  */
    /* JADX WARN: Removed duplicated region for block: B:1160:0x189f  */
    /* JADX WARN: Removed duplicated region for block: B:1168:0x18cd  */
    /* JADX WARN: Removed duplicated region for block: B:1176:0x18fb  */
    /* JADX WARN: Removed duplicated region for block: B:1184:0x1929  */
    /* JADX WARN: Removed duplicated region for block: B:1192:0x1957  */
    /* JADX WARN: Removed duplicated region for block: B:1200:0x1985  */
    /* JADX WARN: Removed duplicated region for block: B:1208:0x19b3  */
    /* JADX WARN: Removed duplicated region for block: B:1214:0x19d5  */
    /* JADX WARN: Removed duplicated region for block: B:1220:0x19f7  */
    /* JADX WARN: Removed duplicated region for block: B:1228:0x1a1d  */
    /* JADX WARN: Removed duplicated region for block: B:1236:0x1a43  */
    /* JADX WARN: Removed duplicated region for block: B:1244:0x1a69  */
    /* JADX WARN: Removed duplicated region for block: B:1250:0x1a8b  */
    /* JADX WARN: Removed duplicated region for block: B:1258:0x1ab1  */
    /* JADX WARN: Removed duplicated region for block: B:1266:0x1ad7  */
    /* JADX WARN: Removed duplicated region for block: B:1274:0x1afd  */
    /* JADX WARN: Removed duplicated region for block: B:1282:0x1b23  */
    /* JADX WARN: Removed duplicated region for block: B:1290:0x1b49  */
    /* JADX WARN: Removed duplicated region for block: B:1296:0x1b6b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:1302:0x1b8d  */
    /* JADX WARN: Removed duplicated region for block: B:1308:0x1baf  */
    /* JADX WARN: Removed duplicated region for block: B:1314:0x1bd1  */
    /* JADX WARN: Removed duplicated region for block: B:1320:0x1bf3  */
    /* JADX WARN: Removed duplicated region for block: B:1326:0x1c15  */
    /* JADX WARN: Removed duplicated region for block: B:1332:0x1c37  */
    /* JADX WARN: Removed duplicated region for block: B:1338:0x1c59  */
    /* JADX WARN: Removed duplicated region for block: B:1344:0x1c7b  */
    /* JADX WARN: Removed duplicated region for block: B:1350:0x1c9d  */
    /* JADX WARN: Removed duplicated region for block: B:1356:0x1cbf  */
    /* JADX WARN: Removed duplicated region for block: B:1362:0x1ce1  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0699  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0743  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0853  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0875  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0897  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x08b9  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0905  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0963  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0985  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x09a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0a23  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0a45  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0a67  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0a89  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0aab  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0acd  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0aef  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0b11  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0b33  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0b55  */
    /* JADX WARN: Removed duplicated region for block: B:562:0x0b77  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0b99  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0bbb  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0bdd  */
    /* JADX WARN: Removed duplicated region for block: B:586:0x0bff  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0c21  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0c43  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0c65  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x0c87  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0ca9  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0ccb  */
    /* JADX WARN: Removed duplicated region for block: B:628:0x0ced  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x0d0f  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x0d31  */
    /* JADX WARN: Removed duplicated region for block: B:646:0x0d53  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0d75  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x0d97  */
    /* JADX WARN: Removed duplicated region for block: B:664:0x0db9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:672:0x0ddf  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0e05  */
    /* JADX WARN: Removed duplicated region for block: B:688:0x0e2b  */
    /* JADX WARN: Removed duplicated region for block: B:696:0x0e51  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:702:0x0e73  */
    /* JADX WARN: Removed duplicated region for block: B:708:0x0e95  */
    /* JADX WARN: Removed duplicated region for block: B:714:0x0eb7  */
    /* JADX WARN: Removed duplicated region for block: B:720:0x0ed9  */
    /* JADX WARN: Removed duplicated region for block: B:726:0x0efb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:732:0x0f1d  */
    /* JADX WARN: Removed duplicated region for block: B:738:0x0f3f  */
    /* JADX WARN: Removed duplicated region for block: B:744:0x0f61  */
    /* JADX WARN: Removed duplicated region for block: B:750:0x0f83  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x0fa5  */
    /* JADX WARN: Removed duplicated region for block: B:762:0x0fc7  */
    /* JADX WARN: Removed duplicated region for block: B:768:0x0fe9  */
    /* JADX WARN: Removed duplicated region for block: B:774:0x100b  */
    /* JADX WARN: Removed duplicated region for block: B:780:0x102d  */
    /* JADX WARN: Removed duplicated region for block: B:786:0x104f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:792:0x1071  */
    /* JADX WARN: Removed duplicated region for block: B:798:0x1093  */
    /* JADX WARN: Removed duplicated region for block: B:804:0x10b5  */
    /* JADX WARN: Removed duplicated region for block: B:810:0x10d7  */
    /* JADX WARN: Removed duplicated region for block: B:816:0x10f9  */
    /* JADX WARN: Removed duplicated region for block: B:822:0x111b  */
    /* JADX WARN: Removed duplicated region for block: B:828:0x113d  */
    /* JADX WARN: Removed duplicated region for block: B:834:0x115f  */
    /* JADX WARN: Removed duplicated region for block: B:840:0x1181  */
    /* JADX WARN: Removed duplicated region for block: B:846:0x11a3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:852:0x11c5  */
    /* JADX WARN: Removed duplicated region for block: B:858:0x11e7  */
    /* JADX WARN: Removed duplicated region for block: B:864:0x1209  */
    /* JADX WARN: Removed duplicated region for block: B:870:0x122b  */
    /* JADX WARN: Removed duplicated region for block: B:876:0x124d  */
    /* JADX WARN: Removed duplicated region for block: B:882:0x126f  */
    /* JADX WARN: Removed duplicated region for block: B:888:0x1291  */
    /* JADX WARN: Removed duplicated region for block: B:894:0x12b3  */
    /* JADX WARN: Removed duplicated region for block: B:900:0x12d5  */
    /* JADX WARN: Removed duplicated region for block: B:906:0x12f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:912:0x1319  */
    /* JADX WARN: Removed duplicated region for block: B:918:0x133b  */
    /* JADX WARN: Removed duplicated region for block: B:924:0x135d  */
    /* JADX WARN: Removed duplicated region for block: B:930:0x137f  */
    /* JADX WARN: Removed duplicated region for block: B:936:0x13a1  */
    /* JADX WARN: Removed duplicated region for block: B:942:0x13c3  */
    /* JADX WARN: Removed duplicated region for block: B:948:0x13e5  */
    /* JADX WARN: Removed duplicated region for block: B:954:0x1407  */
    /* JADX WARN: Removed duplicated region for block: B:960:0x1429  */
    /* JADX WARN: Removed duplicated region for block: B:966:0x144b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:972:0x146d  */
    /* JADX WARN: Removed duplicated region for block: B:978:0x148f  */
    /* JADX WARN: Removed duplicated region for block: B:984:0x14b1  */
    /* JADX WARN: Removed duplicated region for block: B:990:0x14d3  */
    /* JADX WARN: Removed duplicated region for block: B:996:0x14f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean EXT_direct_state_access_initNativeFunctionAddresses(boolean r8, java.util.Set<java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 7400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.EXT_direct_state_access_initNativeFunctionAddresses(boolean, java.util.Set):boolean");
    }

    private boolean EXT_draw_buffers2_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glColorMaskIndexedEXT");
        this.glColorMaskIndexedEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetBooleanIndexedvEXT");
        this.glGetBooleanIndexedvEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT");
        this.glGetIntegerIndexedvEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glEnableIndexedEXT");
        this.glEnableIndexedEXT = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glDisableIndexedEXT");
        this.glDisableIndexedEXT = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glIsEnabledIndexedEXT");
        this.glIsEnabledIndexedEXT = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean EXT_draw_instanced_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawArraysInstancedEXT");
        this.glDrawArraysInstancedEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawElementsInstancedEXT");
        this.glDrawElementsInstancedEXT = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean EXT_draw_range_elements_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawRangeElementsEXT");
        this.glDrawRangeElementsEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_fog_coord_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glFogCoordfEXT");
        this.glFogCoordfEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFogCoorddEXT");
        this.glFogCoorddEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glFogCoordPointerEXT");
        this.glFogCoordPointerEXT = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean EXT_framebuffer_blit_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlitFramebufferEXT");
        this.glBlitFramebufferEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_framebuffer_multisample_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glRenderbufferStorageMultisampleEXT");
        this.glRenderbufferStorageMultisampleEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_framebuffer_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glIsRenderbufferEXT");
        this.glIsRenderbufferEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindRenderbufferEXT");
        this.glBindRenderbufferEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDeleteRenderbuffersEXT");
        this.glDeleteRenderbuffersEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGenRenderbuffersEXT");
        this.glGenRenderbuffersEXT = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glRenderbufferStorageEXT");
        this.glRenderbufferStorageEXT = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetRenderbufferParameterivEXT");
        this.glGetRenderbufferParameterivEXT = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glIsFramebufferEXT");
        this.glIsFramebufferEXT = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glBindFramebufferEXT");
        this.glBindFramebufferEXT = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glDeleteFramebuffersEXT");
        this.glDeleteFramebuffersEXT = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glGenFramebuffersEXT");
        this.glGenFramebuffersEXT = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glCheckFramebufferStatusEXT");
        this.glCheckFramebufferStatusEXT = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glFramebufferTexture1DEXT");
        this.glFramebufferTexture1DEXT = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glFramebufferTexture2DEXT");
        this.glFramebufferTexture2DEXT = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glFramebufferTexture3DEXT");
        this.glFramebufferTexture3DEXT = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glFramebufferRenderbufferEXT");
        this.glFramebufferRenderbufferEXT = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameterivEXT");
        this.glGetFramebufferAttachmentParameterivEXT = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glGenerateMipmapEXT");
        this.glGenerateMipmapEXT = functionAddress17;
        return z16 & (functionAddress17 != 0);
    }

    private boolean EXT_geometry_shader4_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProgramParameteriEXT");
        this.glProgramParameteriEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFramebufferTextureEXT");
        this.glFramebufferTextureEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT");
        this.glFramebufferTextureLayerEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glFramebufferTextureFaceEXT");
        this.glFramebufferTextureFaceEXT = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean EXT_gpu_program_parameters_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProgramEnvParameters4fvEXT");
        this.glProgramEnvParameters4fvEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glProgramLocalParameters4fvEXT");
        this.glProgramLocalParameters4fvEXT = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean EXT_gpu_shader4_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexAttribI1iEXT");
        this.glVertexAttribI1iEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glVertexAttribI2iEXT");
        this.glVertexAttribI2iEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glVertexAttribI3iEXT");
        this.glVertexAttribI3iEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glVertexAttribI4iEXT");
        this.glVertexAttribI4iEXT = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glVertexAttribI1uiEXT");
        this.glVertexAttribI1uiEXT = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glVertexAttribI2uiEXT");
        this.glVertexAttribI2uiEXT = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glVertexAttribI3uiEXT");
        this.glVertexAttribI3uiEXT = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glVertexAttribI4uiEXT");
        this.glVertexAttribI4uiEXT = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glVertexAttribI1ivEXT");
        this.glVertexAttribI1ivEXT = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVertexAttribI2ivEXT");
        this.glVertexAttribI2ivEXT = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glVertexAttribI3ivEXT");
        this.glVertexAttribI3ivEXT = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glVertexAttribI4ivEXT");
        this.glVertexAttribI4ivEXT = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glVertexAttribI1uivEXT");
        this.glVertexAttribI1uivEXT = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glVertexAttribI2uivEXT");
        this.glVertexAttribI2uivEXT = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glVertexAttribI3uivEXT");
        this.glVertexAttribI3uivEXT = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glVertexAttribI4uivEXT");
        this.glVertexAttribI4uivEXT = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glVertexAttribI4bvEXT");
        this.glVertexAttribI4bvEXT = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glVertexAttribI4svEXT");
        this.glVertexAttribI4svEXT = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glVertexAttribI4ubvEXT");
        this.glVertexAttribI4ubvEXT = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glVertexAttribI4usvEXT");
        this.glVertexAttribI4usvEXT = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glVertexAttribIPointerEXT");
        this.glVertexAttribIPointerEXT = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glGetVertexAttribIivEXT");
        this.glGetVertexAttribIivEXT = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glGetVertexAttribIuivEXT");
        this.glGetVertexAttribIuivEXT = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glUniform1uiEXT");
        this.glUniform1uiEXT = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glUniform2uiEXT");
        this.glUniform2uiEXT = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glUniform3uiEXT");
        this.glUniform3uiEXT = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glUniform4uiEXT");
        this.glUniform4uiEXT = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glUniform1uivEXT");
        this.glUniform1uivEXT = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glUniform2uivEXT");
        this.glUniform2uivEXT = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glUniform3uivEXT");
        this.glUniform3uivEXT = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glUniform4uivEXT");
        this.glUniform4uivEXT = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glGetUniformuivEXT");
        this.glGetUniformuivEXT = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glBindFragDataLocationEXT");
        this.glBindFragDataLocationEXT = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glGetFragDataLocationEXT");
        this.glGetFragDataLocationEXT = functionAddress34;
        return z33 & (functionAddress34 != 0);
    }

    private boolean EXT_multi_draw_arrays_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMultiDrawArraysEXT");
        this.glMultiDrawArraysEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_paletted_texture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glColorTableEXT");
        this.glColorTableEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glColorSubTableEXT");
        this.glColorSubTableEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetColorTableEXT");
        this.glGetColorTableEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetColorTableParameterivEXT");
        this.glGetColorTableParameterivEXT = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetColorTableParameterfvEXT");
        this.glGetColorTableParameterfvEXT = functionAddress5;
        return z4 & (functionAddress5 != 0);
    }

    private boolean EXT_point_parameters_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPointParameterfEXT");
        this.glPointParameterfEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glPointParameterfvEXT");
        this.glPointParameterfvEXT = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean EXT_provoking_vertex_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProvokingVertexEXT");
        this.glProvokingVertexEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_secondary_color_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glSecondaryColor3bEXT");
        this.glSecondaryColor3bEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glSecondaryColor3fEXT");
        this.glSecondaryColor3fEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glSecondaryColor3dEXT");
        this.glSecondaryColor3dEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glSecondaryColor3ubEXT");
        this.glSecondaryColor3ubEXT = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glSecondaryColorPointerEXT");
        this.glSecondaryColorPointerEXT = functionAddress5;
        return z4 & (functionAddress5 != 0);
    }

    private boolean EXT_separate_shader_objects_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glUseShaderProgramEXT");
        this.glUseShaderProgramEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glActiveProgramEXT");
        this.glActiveProgramEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glCreateShaderProgramEXT");
        this.glCreateShaderProgramEXT = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean EXT_shader_image_load_store_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindImageTextureEXT");
        this.glBindImageTextureEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMemoryBarrierEXT");
        this.glMemoryBarrierEXT = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean EXT_stencil_clear_tag_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glStencilClearTagEXT");
        this.glStencilClearTagEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_stencil_two_side_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glActiveStencilFaceEXT");
        this.glActiveStencilFaceEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_texture_array_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT");
        this.glFramebufferTextureLayerEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_texture_buffer_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTexBufferEXT");
        this.glTexBufferEXT = functionAddress;
        return functionAddress != 0;
    }

    private boolean EXT_texture_integer_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glClearColorIiEXT");
        this.glClearColorIiEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glClearColorIuiEXT");
        this.glClearColorIuiEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glTexParameterIivEXT");
        this.glTexParameterIivEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glTexParameterIuivEXT");
        this.glTexParameterIuivEXT = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetTexParameterIivEXT");
        this.glGetTexParameterIivEXT = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetTexParameterIuivEXT");
        this.glGetTexParameterIuivEXT = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean EXT_timer_query_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetQueryObjecti64vEXT");
        this.glGetQueryObjecti64vEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetQueryObjectui64vEXT");
        this.glGetQueryObjectui64vEXT = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean EXT_transform_feedback_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindBufferRangeEXT");
        this.glBindBufferRangeEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindBufferOffsetEXT");
        this.glBindBufferOffsetEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glBindBufferBaseEXT");
        this.glBindBufferBaseEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBeginTransformFeedbackEXT");
        this.glBeginTransformFeedbackEXT = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glEndTransformFeedbackEXT");
        this.glEndTransformFeedbackEXT = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glTransformFeedbackVaryingsEXT");
        this.glTransformFeedbackVaryingsEXT = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetTransformFeedbackVaryingEXT");
        this.glGetTransformFeedbackVaryingEXT = functionAddress7;
        return z6 & (functionAddress7 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean EXT_vertex_attrib_64bit_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.EXT_vertex_attrib_64bit_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean EXT_vertex_shader_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBeginVertexShaderEXT");
        this.glBeginVertexShaderEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glEndVertexShaderEXT");
        this.glEndVertexShaderEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glBindVertexShaderEXT");
        this.glBindVertexShaderEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGenVertexShadersEXT");
        this.glGenVertexShadersEXT = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glDeleteVertexShaderEXT");
        this.glDeleteVertexShaderEXT = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glShaderOp1EXT");
        this.glShaderOp1EXT = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glShaderOp2EXT");
        this.glShaderOp2EXT = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glShaderOp3EXT");
        this.glShaderOp3EXT = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glSwizzleEXT");
        this.glSwizzleEXT = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glWriteMaskEXT");
        this.glWriteMaskEXT = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glInsertComponentEXT");
        this.glInsertComponentEXT = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glExtractComponentEXT");
        this.glExtractComponentEXT = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glGenSymbolsEXT");
        this.glGenSymbolsEXT = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glSetInvariantEXT");
        this.glSetInvariantEXT = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glSetLocalConstantEXT");
        this.glSetLocalConstantEXT = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glVariantbvEXT");
        this.glVariantbvEXT = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glVariantsvEXT");
        this.glVariantsvEXT = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glVariantivEXT");
        this.glVariantivEXT = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glVariantfvEXT");
        this.glVariantfvEXT = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glVariantdvEXT");
        this.glVariantdvEXT = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glVariantubvEXT");
        this.glVariantubvEXT = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glVariantusvEXT");
        this.glVariantusvEXT = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glVariantuivEXT");
        this.glVariantuivEXT = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glVariantPointerEXT");
        this.glVariantPointerEXT = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glEnableVariantClientStateEXT");
        this.glEnableVariantClientStateEXT = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glDisableVariantClientStateEXT");
        this.glDisableVariantClientStateEXT = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glBindLightParameterEXT");
        this.glBindLightParameterEXT = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glBindMaterialParameterEXT");
        this.glBindMaterialParameterEXT = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glBindTexGenParameterEXT");
        this.glBindTexGenParameterEXT = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glBindTextureUnitParameterEXT");
        this.glBindTextureUnitParameterEXT = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glBindParameterEXT");
        this.glBindParameterEXT = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glIsVariantEnabledEXT");
        this.glIsVariantEnabledEXT = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glGetVariantBooleanvEXT");
        this.glGetVariantBooleanvEXT = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glGetVariantIntegervEXT");
        this.glGetVariantIntegervEXT = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glGetVariantFloatvEXT");
        this.glGetVariantFloatvEXT = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glGetVariantPointervEXT");
        this.glGetVariantPointervEXT = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glGetInvariantBooleanvEXT");
        this.glGetInvariantBooleanvEXT = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glGetInvariantIntegervEXT");
        this.glGetInvariantIntegervEXT = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glGetInvariantFloatvEXT");
        this.glGetInvariantFloatvEXT = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glGetLocalConstantBooleanvEXT");
        this.glGetLocalConstantBooleanvEXT = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glGetLocalConstantIntegervEXT");
        this.glGetLocalConstantIntegervEXT = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glGetLocalConstantFloatvEXT");
        this.glGetLocalConstantFloatvEXT = functionAddress42;
        return z41 & (functionAddress42 != 0);
    }

    private boolean EXT_vertex_weighting_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexWeightfEXT");
        this.glVertexWeightfEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glVertexWeightPointerEXT");
        this.glVertexWeightPointerEXT = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:1000:0x11f5  */
    /* JADX WARN: Removed duplicated region for block: B:1010:0x1225  */
    /* JADX WARN: Removed duplicated region for block: B:1016:0x123f  */
    /* JADX WARN: Removed duplicated region for block: B:1022:0x1259  */
    /* JADX WARN: Removed duplicated region for block: B:1028:0x1273  */
    /* JADX WARN: Removed duplicated region for block: B:1034:0x128d  */
    /* JADX WARN: Removed duplicated region for block: B:1040:0x12a7  */
    /* JADX WARN: Removed duplicated region for block: B:1046:0x12c1  */
    /* JADX WARN: Removed duplicated region for block: B:1052:0x12db  */
    /* JADX WARN: Removed duplicated region for block: B:1058:0x12f5  */
    /* JADX WARN: Removed duplicated region for block: B:1064:0x130f  */
    /* JADX WARN: Removed duplicated region for block: B:1070:0x1329  */
    /* JADX WARN: Removed duplicated region for block: B:1076:0x1343  */
    /* JADX WARN: Removed duplicated region for block: B:1114:0x140d  */
    /* JADX WARN: Removed duplicated region for block: B:1120:0x1427  */
    /* JADX WARN: Removed duplicated region for block: B:1126:0x1441  */
    /* JADX WARN: Removed duplicated region for block: B:1132:0x145b  */
    /* JADX WARN: Removed duplicated region for block: B:1138:0x1475  */
    /* JADX WARN: Removed duplicated region for block: B:1144:0x148f  */
    /* JADX WARN: Removed duplicated region for block: B:1166:0x1501  */
    /* JADX WARN: Removed duplicated region for block: B:1172:0x151b  */
    /* JADX WARN: Removed duplicated region for block: B:1178:0x1535  */
    /* JADX WARN: Removed duplicated region for block: B:1184:0x154f  */
    /* JADX WARN: Removed duplicated region for block: B:1190:0x1569  */
    /* JADX WARN: Removed duplicated region for block: B:1196:0x1583  */
    /* JADX WARN: Removed duplicated region for block: B:1202:0x159d  */
    /* JADX WARN: Removed duplicated region for block: B:1208:0x15b7  */
    /* JADX WARN: Removed duplicated region for block: B:1214:0x15d1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x074f  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0799  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x07b3  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x07cd  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x07e7  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x090d  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0941  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x099d  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x09b7  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x09d1  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x09eb  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0a05  */
    /* JADX WARN: Removed duplicated region for block: B:550:0x0a1f  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0a39  */
    /* JADX WARN: Removed duplicated region for block: B:562:0x0a53  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0a6d  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x0a87  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0aa1  */
    /* JADX WARN: Removed duplicated region for block: B:586:0x0abb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0ad5  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0aef  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0b1f  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x0b39  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0b53  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0b6d  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x0b87  */
    /* JADX WARN: Removed duplicated region for block: B:642:0x0bb7  */
    /* JADX WARN: Removed duplicated region for block: B:648:0x0bd1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:654:0x0beb  */
    /* JADX WARN: Removed duplicated region for block: B:660:0x0c05  */
    /* JADX WARN: Removed duplicated region for block: B:666:0x0c1f  */
    /* JADX WARN: Removed duplicated region for block: B:672:0x0c39  */
    /* JADX WARN: Removed duplicated region for block: B:678:0x0c53  */
    /* JADX WARN: Removed duplicated region for block: B:684:0x0c6d  */
    /* JADX WARN: Removed duplicated region for block: B:690:0x0c87  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x0cb7  */
    /* JADX WARN: Removed duplicated region for block: B:706:0x0cd1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:724:0x0d2d  */
    /* JADX WARN: Removed duplicated region for block: B:730:0x0d47  */
    /* JADX WARN: Removed duplicated region for block: B:736:0x0d61  */
    /* JADX WARN: Removed duplicated region for block: B:750:0x0da7  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x0dc1  */
    /* JADX WARN: Removed duplicated region for block: B:762:0x0ddb  */
    /* JADX WARN: Removed duplicated region for block: B:768:0x0df5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:774:0x0e0f  */
    /* JADX WARN: Removed duplicated region for block: B:780:0x0e29  */
    /* JADX WARN: Removed duplicated region for block: B:786:0x0e43  */
    /* JADX WARN: Removed duplicated region for block: B:792:0x0e5d  */
    /* JADX WARN: Removed duplicated region for block: B:798:0x0e77  */
    /* JADX WARN: Removed duplicated region for block: B:804:0x0e91  */
    /* JADX WARN: Removed duplicated region for block: B:810:0x0eab  */
    /* JADX WARN: Removed duplicated region for block: B:816:0x0ec5  */
    /* JADX WARN: Removed duplicated region for block: B:822:0x0edf  */
    /* JADX WARN: Removed duplicated region for block: B:828:0x0ef9  */
    /* JADX WARN: Removed duplicated region for block: B:838:0x0f29  */
    /* JADX WARN: Removed duplicated region for block: B:848:0x0f59  */
    /* JADX WARN: Removed duplicated region for block: B:854:0x0f73  */
    /* JADX WARN: Removed duplicated region for block: B:860:0x0f8d  */
    /* JADX WARN: Removed duplicated region for block: B:866:0x0fa7  */
    /* JADX WARN: Removed duplicated region for block: B:872:0x0fc1  */
    /* JADX WARN: Removed duplicated region for block: B:878:0x0fdb  */
    /* JADX WARN: Removed duplicated region for block: B:884:0x0ff5  */
    /* JADX WARN: Removed duplicated region for block: B:890:0x100f  */
    /* JADX WARN: Removed duplicated region for block: B:904:0x1055  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:910:0x106f  */
    /* JADX WARN: Removed duplicated region for block: B:916:0x1089  */
    /* JADX WARN: Removed duplicated region for block: B:922:0x10a3  */
    /* JADX WARN: Removed duplicated region for block: B:928:0x10bd  */
    /* JADX WARN: Removed duplicated region for block: B:934:0x10d7  */
    /* JADX WARN: Removed duplicated region for block: B:940:0x10f1  */
    /* JADX WARN: Removed duplicated region for block: B:946:0x110b  */
    /* JADX WARN: Removed duplicated region for block: B:952:0x1125  */
    /* JADX WARN: Removed duplicated region for block: B:958:0x113f  */
    /* JADX WARN: Removed duplicated region for block: B:964:0x1159  */
    /* JADX WARN: Removed duplicated region for block: B:970:0x1173  */
    /* JADX WARN: Removed duplicated region for block: B:976:0x118d  */
    /* JADX WARN: Removed duplicated region for block: B:982:0x11a7  */
    /* JADX WARN: Removed duplicated region for block: B:988:0x11c1  */
    /* JADX WARN: Removed duplicated region for block: B:994:0x11db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean GL11_initNativeFunctionAddresses(boolean r8) {
        /*
            Method dump skipped, instruction units count: 5658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.GL11_initNativeFunctionAddresses(boolean):boolean");
    }

    private boolean GL12_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawRangeElements");
        this.glDrawRangeElements = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glTexImage3D");
        this.glTexImage3D = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glTexSubImage3D");
        this.glTexSubImage3D = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glCopyTexSubImage3D");
        this.glCopyTexSubImage3D = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean GL13_initNativeFunctionAddresses(boolean r8) {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.GL13_initNativeFunctionAddresses(boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean GL14_initNativeFunctionAddresses(boolean r8) {
        /*
            Method dump skipped, instruction units count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.GL14_initNativeFunctionAddresses(boolean):boolean");
    }

    private boolean GL15_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindBuffer");
        this.glBindBuffer = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteBuffers");
        this.glDeleteBuffers = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGenBuffers");
        this.glGenBuffers = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glIsBuffer");
        this.glIsBuffer = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glBufferData");
        this.glBufferData = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glBufferSubData");
        this.glBufferSubData = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetBufferSubData");
        this.glGetBufferSubData = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glMapBuffer");
        this.glMapBuffer = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glUnmapBuffer");
        this.glUnmapBuffer = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glGetBufferParameteriv");
        this.glGetBufferParameteriv = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetBufferPointerv");
        this.glGetBufferPointerv = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glGenQueries");
        this.glGenQueries = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glDeleteQueries");
        this.glDeleteQueries = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glIsQuery");
        this.glIsQuery = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glBeginQuery");
        this.glBeginQuery = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glEndQuery");
        this.glEndQuery = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glGetQueryiv");
        this.glGetQueryiv = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glGetQueryObjectiv");
        this.glGetQueryObjectiv = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glGetQueryObjectuiv");
        this.glGetQueryObjectuiv = functionAddress19;
        return z18 & (functionAddress19 != 0);
    }

    private boolean GL20_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glShaderSource");
        this.glShaderSource = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glCreateShader");
        this.glCreateShader = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glIsShader");
        this.glIsShader = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glCompileShader");
        this.glCompileShader = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glDeleteShader");
        this.glDeleteShader = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glCreateProgram");
        this.glCreateProgram = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glIsProgram");
        this.glIsProgram = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glAttachShader");
        this.glAttachShader = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glDetachShader");
        this.glDetachShader = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glLinkProgram");
        this.glLinkProgram = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glUseProgram");
        this.glUseProgram = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glValidateProgram");
        this.glValidateProgram = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glDeleteProgram");
        this.glDeleteProgram = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glUniform1f");
        this.glUniform1f = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glUniform2f");
        this.glUniform2f = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glUniform3f");
        this.glUniform3f = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glUniform4f");
        this.glUniform4f = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glUniform1i");
        this.glUniform1i = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glUniform2i");
        this.glUniform2i = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glUniform3i");
        this.glUniform3i = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glUniform4i");
        this.glUniform4i = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glUniform1fv");
        this.glUniform1fv = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glUniform2fv");
        this.glUniform2fv = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glUniform3fv");
        this.glUniform3fv = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glUniform4fv");
        this.glUniform4fv = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glUniform1iv");
        this.glUniform1iv = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glUniform2iv");
        this.glUniform2iv = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glUniform3iv");
        this.glUniform3iv = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glUniform4iv");
        this.glUniform4iv = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glUniformMatrix2fv");
        this.glUniformMatrix2fv = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glUniformMatrix3fv");
        this.glUniformMatrix3fv = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glUniformMatrix4fv");
        this.glUniformMatrix4fv = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glGetShaderiv");
        this.glGetShaderiv = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glGetProgramiv");
        this.glGetProgramiv = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glGetShaderInfoLog");
        this.glGetShaderInfoLog = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glGetProgramInfoLog");
        this.glGetProgramInfoLog = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glGetAttachedShaders");
        this.glGetAttachedShaders = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glGetUniformLocation");
        this.glGetUniformLocation = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glGetActiveUniform");
        this.glGetActiveUniform = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glGetUniformfv");
        this.glGetUniformfv = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glGetUniformiv");
        this.glGetUniformiv = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glGetShaderSource");
        this.glGetShaderSource = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glVertexAttrib1s");
        this.glVertexAttrib1s = functionAddress43;
        boolean z43 = z42 & (functionAddress43 != 0);
        long functionAddress44 = GLContext.getFunctionAddress("glVertexAttrib1f");
        this.glVertexAttrib1f = functionAddress44;
        boolean z44 = z43 & (functionAddress44 != 0);
        long functionAddress45 = GLContext.getFunctionAddress("glVertexAttrib1d");
        this.glVertexAttrib1d = functionAddress45;
        boolean z45 = z44 & (functionAddress45 != 0);
        long functionAddress46 = GLContext.getFunctionAddress("glVertexAttrib2s");
        this.glVertexAttrib2s = functionAddress46;
        boolean z46 = z45 & (functionAddress46 != 0);
        long functionAddress47 = GLContext.getFunctionAddress("glVertexAttrib2f");
        this.glVertexAttrib2f = functionAddress47;
        boolean z47 = z46 & (functionAddress47 != 0);
        long functionAddress48 = GLContext.getFunctionAddress("glVertexAttrib2d");
        this.glVertexAttrib2d = functionAddress48;
        boolean z48 = z47 & (functionAddress48 != 0);
        long functionAddress49 = GLContext.getFunctionAddress("glVertexAttrib3s");
        this.glVertexAttrib3s = functionAddress49;
        boolean z49 = z48 & (functionAddress49 != 0);
        long functionAddress50 = GLContext.getFunctionAddress("glVertexAttrib3f");
        this.glVertexAttrib3f = functionAddress50;
        boolean z50 = z49 & (functionAddress50 != 0);
        long functionAddress51 = GLContext.getFunctionAddress("glVertexAttrib3d");
        this.glVertexAttrib3d = functionAddress51;
        boolean z51 = z50 & (functionAddress51 != 0);
        long functionAddress52 = GLContext.getFunctionAddress("glVertexAttrib4s");
        this.glVertexAttrib4s = functionAddress52;
        boolean z52 = z51 & (functionAddress52 != 0);
        long functionAddress53 = GLContext.getFunctionAddress("glVertexAttrib4f");
        this.glVertexAttrib4f = functionAddress53;
        boolean z53 = z52 & (functionAddress53 != 0);
        long functionAddress54 = GLContext.getFunctionAddress("glVertexAttrib4d");
        this.glVertexAttrib4d = functionAddress54;
        boolean z54 = z53 & (functionAddress54 != 0);
        long functionAddress55 = GLContext.getFunctionAddress("glVertexAttrib4Nub");
        this.glVertexAttrib4Nub = functionAddress55;
        boolean z55 = z54 & (functionAddress55 != 0);
        long functionAddress56 = GLContext.getFunctionAddress("glVertexAttribPointer");
        this.glVertexAttribPointer = functionAddress56;
        boolean z56 = z55 & (functionAddress56 != 0);
        long functionAddress57 = GLContext.getFunctionAddress("glEnableVertexAttribArray");
        this.glEnableVertexAttribArray = functionAddress57;
        boolean z57 = z56 & (functionAddress57 != 0);
        long functionAddress58 = GLContext.getFunctionAddress("glDisableVertexAttribArray");
        this.glDisableVertexAttribArray = functionAddress58;
        boolean z58 = z57 & (functionAddress58 != 0);
        long functionAddress59 = GLContext.getFunctionAddress("glGetVertexAttribfv");
        this.glGetVertexAttribfv = functionAddress59;
        boolean z59 = z58 & (functionAddress59 != 0);
        long functionAddress60 = GLContext.getFunctionAddress("glGetVertexAttribdv");
        this.glGetVertexAttribdv = functionAddress60;
        boolean z60 = z59 & (functionAddress60 != 0);
        long functionAddress61 = GLContext.getFunctionAddress("glGetVertexAttribiv");
        this.glGetVertexAttribiv = functionAddress61;
        boolean z61 = z60 & (functionAddress61 != 0);
        long functionAddress62 = GLContext.getFunctionAddress("glGetVertexAttribPointerv");
        this.glGetVertexAttribPointerv = functionAddress62;
        boolean z62 = z61 & (functionAddress62 != 0);
        long functionAddress63 = GLContext.getFunctionAddress("glBindAttribLocation");
        this.glBindAttribLocation = functionAddress63;
        boolean z63 = z62 & (functionAddress63 != 0);
        long functionAddress64 = GLContext.getFunctionAddress("glGetActiveAttrib");
        this.glGetActiveAttrib = functionAddress64;
        boolean z64 = z63 & (functionAddress64 != 0);
        long functionAddress65 = GLContext.getFunctionAddress("glGetAttribLocation");
        this.glGetAttribLocation = functionAddress65;
        boolean z65 = z64 & (functionAddress65 != 0);
        long functionAddress66 = GLContext.getFunctionAddress("glDrawBuffers");
        this.glDrawBuffers = functionAddress66;
        boolean z66 = z65 & (functionAddress66 != 0);
        long functionAddress67 = GLContext.getFunctionAddress("glStencilOpSeparate");
        this.glStencilOpSeparate = functionAddress67;
        boolean z67 = z66 & (functionAddress67 != 0);
        long functionAddress68 = GLContext.getFunctionAddress("glStencilFuncSeparate");
        this.glStencilFuncSeparate = functionAddress68;
        boolean z68 = z67 & (functionAddress68 != 0);
        long functionAddress69 = GLContext.getFunctionAddress("glStencilMaskSeparate");
        this.glStencilMaskSeparate = functionAddress69;
        boolean z69 = z68 & (functionAddress69 != 0);
        long functionAddress70 = GLContext.getFunctionAddress("glBlendEquationSeparate");
        this.glBlendEquationSeparate = functionAddress70;
        return z69 & (functionAddress70 != 0);
    }

    private boolean GL21_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glUniformMatrix2x3fv");
        this.glUniformMatrix2x3fv = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glUniformMatrix3x2fv");
        this.glUniformMatrix3x2fv = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glUniformMatrix2x4fv");
        this.glUniformMatrix2x4fv = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glUniformMatrix4x2fv");
        this.glUniformMatrix4x2fv = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glUniformMatrix3x4fv");
        this.glUniformMatrix3x4fv = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glUniformMatrix4x3fv");
        this.glUniformMatrix4x3fv = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean GL30_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetStringi");
        this.glGetStringi = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glClearBufferfv");
        this.glClearBufferfv = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glClearBufferiv");
        this.glClearBufferiv = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glClearBufferuiv");
        this.glClearBufferuiv = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glClearBufferfi");
        this.glClearBufferfi = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glVertexAttribI1i");
        this.glVertexAttribI1i = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glVertexAttribI2i");
        this.glVertexAttribI2i = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glVertexAttribI3i");
        this.glVertexAttribI3i = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glVertexAttribI4i");
        this.glVertexAttribI4i = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVertexAttribI1ui");
        this.glVertexAttribI1ui = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glVertexAttribI2ui");
        this.glVertexAttribI2ui = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glVertexAttribI3ui");
        this.glVertexAttribI3ui = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glVertexAttribI4ui");
        this.glVertexAttribI4ui = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glVertexAttribI1iv");
        this.glVertexAttribI1iv = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glVertexAttribI2iv");
        this.glVertexAttribI2iv = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glVertexAttribI3iv");
        this.glVertexAttribI3iv = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glVertexAttribI4iv");
        this.glVertexAttribI4iv = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glVertexAttribI1uiv");
        this.glVertexAttribI1uiv = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glVertexAttribI2uiv");
        this.glVertexAttribI2uiv = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glVertexAttribI3uiv");
        this.glVertexAttribI3uiv = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glVertexAttribI4uiv");
        this.glVertexAttribI4uiv = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glVertexAttribI4bv");
        this.glVertexAttribI4bv = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glVertexAttribI4sv");
        this.glVertexAttribI4sv = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glVertexAttribI4ubv");
        this.glVertexAttribI4ubv = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glVertexAttribI4usv");
        this.glVertexAttribI4usv = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glVertexAttribIPointer");
        this.glVertexAttribIPointer = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glGetVertexAttribIiv");
        this.glGetVertexAttribIiv = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glGetVertexAttribIuiv");
        this.glGetVertexAttribIuiv = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glUniform1ui");
        this.glUniform1ui = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glUniform2ui");
        this.glUniform2ui = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glUniform3ui");
        this.glUniform3ui = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glUniform4ui");
        this.glUniform4ui = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glUniform1uiv");
        this.glUniform1uiv = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glUniform2uiv");
        this.glUniform2uiv = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glUniform3uiv");
        this.glUniform3uiv = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glUniform4uiv");
        this.glUniform4uiv = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glGetUniformuiv");
        this.glGetUniformuiv = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glBindFragDataLocation");
        this.glBindFragDataLocation = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glGetFragDataLocation");
        this.glGetFragDataLocation = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glBeginConditionalRender");
        this.glBeginConditionalRender = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glEndConditionalRender");
        this.glEndConditionalRender = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glMapBufferRange");
        this.glMapBufferRange = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glFlushMappedBufferRange");
        this.glFlushMappedBufferRange = functionAddress43;
        boolean z43 = z42 & (functionAddress43 != 0);
        long functionAddress44 = GLContext.getFunctionAddress("glClampColor");
        this.glClampColor = functionAddress44;
        boolean z44 = z43 & (functionAddress44 != 0);
        long functionAddress45 = GLContext.getFunctionAddress("glIsRenderbuffer");
        this.glIsRenderbuffer = functionAddress45;
        boolean z45 = z44 & (functionAddress45 != 0);
        long functionAddress46 = GLContext.getFunctionAddress("glBindRenderbuffer");
        this.glBindRenderbuffer = functionAddress46;
        boolean z46 = z45 & (functionAddress46 != 0);
        long functionAddress47 = GLContext.getFunctionAddress("glDeleteRenderbuffers");
        this.glDeleteRenderbuffers = functionAddress47;
        boolean z47 = z46 & (functionAddress47 != 0);
        long functionAddress48 = GLContext.getFunctionAddress("glGenRenderbuffers");
        this.glGenRenderbuffers = functionAddress48;
        boolean z48 = z47 & (functionAddress48 != 0);
        long functionAddress49 = GLContext.getFunctionAddress("glRenderbufferStorage");
        this.glRenderbufferStorage = functionAddress49;
        boolean z49 = z48 & (functionAddress49 != 0);
        long functionAddress50 = GLContext.getFunctionAddress("glGetRenderbufferParameteriv");
        this.glGetRenderbufferParameteriv = functionAddress50;
        boolean z50 = z49 & (functionAddress50 != 0);
        long functionAddress51 = GLContext.getFunctionAddress("glIsFramebuffer");
        this.glIsFramebuffer = functionAddress51;
        boolean z51 = z50 & (functionAddress51 != 0);
        long functionAddress52 = GLContext.getFunctionAddress("glBindFramebuffer");
        this.glBindFramebuffer = functionAddress52;
        boolean z52 = z51 & (functionAddress52 != 0);
        long functionAddress53 = GLContext.getFunctionAddress("glDeleteFramebuffers");
        this.glDeleteFramebuffers = functionAddress53;
        boolean z53 = z52 & (functionAddress53 != 0);
        long functionAddress54 = GLContext.getFunctionAddress("glGenFramebuffers");
        this.glGenFramebuffers = functionAddress54;
        boolean z54 = z53 & (functionAddress54 != 0);
        long functionAddress55 = GLContext.getFunctionAddress("glCheckFramebufferStatus");
        this.glCheckFramebufferStatus = functionAddress55;
        boolean z55 = z54 & (functionAddress55 != 0);
        long functionAddress56 = GLContext.getFunctionAddress("glFramebufferTexture1D");
        this.glFramebufferTexture1D = functionAddress56;
        boolean z56 = z55 & (functionAddress56 != 0);
        long functionAddress57 = GLContext.getFunctionAddress("glFramebufferTexture2D");
        this.glFramebufferTexture2D = functionAddress57;
        boolean z57 = z56 & (functionAddress57 != 0);
        long functionAddress58 = GLContext.getFunctionAddress("glFramebufferTexture3D");
        this.glFramebufferTexture3D = functionAddress58;
        boolean z58 = z57 & (functionAddress58 != 0);
        long functionAddress59 = GLContext.getFunctionAddress("glFramebufferRenderbuffer");
        this.glFramebufferRenderbuffer = functionAddress59;
        boolean z59 = z58 & (functionAddress59 != 0);
        long functionAddress60 = GLContext.getFunctionAddress("glGetFramebufferAttachmentParameteriv");
        this.glGetFramebufferAttachmentParameteriv = functionAddress60;
        boolean z60 = z59 & (functionAddress60 != 0);
        long functionAddress61 = GLContext.getFunctionAddress("glGenerateMipmap");
        this.glGenerateMipmap = functionAddress61;
        boolean z61 = z60 & (functionAddress61 != 0);
        long functionAddress62 = GLContext.getFunctionAddress("glRenderbufferStorageMultisample");
        this.glRenderbufferStorageMultisample = functionAddress62;
        boolean z62 = z61 & (functionAddress62 != 0);
        long functionAddress63 = GLContext.getFunctionAddress("glBlitFramebuffer");
        this.glBlitFramebuffer = functionAddress63;
        boolean z63 = z62 & (functionAddress63 != 0);
        long functionAddress64 = GLContext.getFunctionAddress("glTexParameterIiv");
        this.glTexParameterIiv = functionAddress64;
        boolean z64 = z63 & (functionAddress64 != 0);
        long functionAddress65 = GLContext.getFunctionAddress("glTexParameterIuiv");
        this.glTexParameterIuiv = functionAddress65;
        boolean z65 = z64 & (functionAddress65 != 0);
        long functionAddress66 = GLContext.getFunctionAddress("glGetTexParameterIiv");
        this.glGetTexParameterIiv = functionAddress66;
        boolean z66 = z65 & (functionAddress66 != 0);
        long functionAddress67 = GLContext.getFunctionAddress("glGetTexParameterIuiv");
        this.glGetTexParameterIuiv = functionAddress67;
        boolean z67 = z66 & (functionAddress67 != 0);
        long functionAddress68 = GLContext.getFunctionAddress("glFramebufferTextureLayer");
        this.glFramebufferTextureLayer = functionAddress68;
        boolean z68 = z67 & (functionAddress68 != 0);
        long functionAddress69 = GLContext.getFunctionAddress("glColorMaski");
        this.glColorMaski = functionAddress69;
        boolean z69 = z68 & (functionAddress69 != 0);
        long functionAddress70 = GLContext.getFunctionAddress("glGetBooleani_v");
        this.glGetBooleani_v = functionAddress70;
        boolean z70 = z69 & (functionAddress70 != 0);
        long functionAddress71 = GLContext.getFunctionAddress("glGetIntegeri_v");
        this.glGetIntegeri_v = functionAddress71;
        boolean z71 = z70 & (functionAddress71 != 0);
        long functionAddress72 = GLContext.getFunctionAddress("glEnablei");
        this.glEnablei = functionAddress72;
        boolean z72 = z71 & (functionAddress72 != 0);
        long functionAddress73 = GLContext.getFunctionAddress("glDisablei");
        this.glDisablei = functionAddress73;
        boolean z73 = z72 & (functionAddress73 != 0);
        long functionAddress74 = GLContext.getFunctionAddress("glIsEnabledi");
        this.glIsEnabledi = functionAddress74;
        boolean z74 = z73 & (functionAddress74 != 0);
        long functionAddress75 = GLContext.getFunctionAddress("glBindBufferRange");
        this.glBindBufferRange = functionAddress75;
        boolean z75 = z74 & (functionAddress75 != 0);
        long functionAddress76 = GLContext.getFunctionAddress("glBindBufferBase");
        this.glBindBufferBase = functionAddress76;
        boolean z76 = z75 & (functionAddress76 != 0);
        long functionAddress77 = GLContext.getFunctionAddress("glBeginTransformFeedback");
        this.glBeginTransformFeedback = functionAddress77;
        boolean z77 = z76 & (functionAddress77 != 0);
        long functionAddress78 = GLContext.getFunctionAddress("glEndTransformFeedback");
        this.glEndTransformFeedback = functionAddress78;
        boolean z78 = z77 & (functionAddress78 != 0);
        long functionAddress79 = GLContext.getFunctionAddress("glTransformFeedbackVaryings");
        this.glTransformFeedbackVaryings = functionAddress79;
        boolean z79 = z78 & (functionAddress79 != 0);
        long functionAddress80 = GLContext.getFunctionAddress("glGetTransformFeedbackVarying");
        this.glGetTransformFeedbackVarying = functionAddress80;
        boolean z80 = z79 & (functionAddress80 != 0);
        long functionAddress81 = GLContext.getFunctionAddress("glBindVertexArray");
        this.glBindVertexArray = functionAddress81;
        boolean z81 = z80 & (functionAddress81 != 0);
        long functionAddress82 = GLContext.getFunctionAddress("glDeleteVertexArrays");
        this.glDeleteVertexArrays = functionAddress82;
        boolean z82 = z81 & (functionAddress82 != 0);
        long functionAddress83 = GLContext.getFunctionAddress("glGenVertexArrays");
        this.glGenVertexArrays = functionAddress83;
        boolean z83 = z82 & (functionAddress83 != 0);
        long functionAddress84 = GLContext.getFunctionAddress("glIsVertexArray");
        this.glIsVertexArray = functionAddress84;
        return z83 & (functionAddress84 != 0);
    }

    private boolean GL31_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawArraysInstanced");
        this.glDrawArraysInstanced = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawElementsInstanced");
        this.glDrawElementsInstanced = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glCopyBufferSubData");
        this.glCopyBufferSubData = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glPrimitiveRestartIndex");
        this.glPrimitiveRestartIndex = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glTexBuffer");
        this.glTexBuffer = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetUniformIndices");
        this.glGetUniformIndices = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetActiveUniformsiv");
        this.glGetActiveUniformsiv = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetActiveUniformName");
        this.glGetActiveUniformName = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetUniformBlockIndex");
        this.glGetUniformBlockIndex = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glGetActiveUniformBlockiv");
        this.glGetActiveUniformBlockiv = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetActiveUniformBlockName");
        this.glGetActiveUniformBlockName = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glUniformBlockBinding");
        this.glUniformBlockBinding = functionAddress12;
        return z11 & (functionAddress12 != 0);
    }

    private boolean GL32_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetBufferParameteri64v");
        this.glGetBufferParameteri64v = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDrawElementsBaseVertex");
        this.glDrawElementsBaseVertex = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDrawRangeElementsBaseVertex");
        this.glDrawRangeElementsBaseVertex = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertex");
        this.glDrawElementsInstancedBaseVertex = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glProvokingVertex");
        this.glProvokingVertex = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glTexImage2DMultisample");
        this.glTexImage2DMultisample = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glTexImage3DMultisample");
        this.glTexImage3DMultisample = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetMultisamplefv");
        this.glGetMultisamplefv = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glSampleMaski");
        this.glSampleMaski = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glFramebufferTexture");
        this.glFramebufferTexture = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glFenceSync");
        this.glFenceSync = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glIsSync");
        this.glIsSync = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glDeleteSync");
        this.glDeleteSync = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glClientWaitSync");
        this.glClientWaitSync = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glWaitSync");
        this.glWaitSync = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glGetInteger64v");
        this.glGetInteger64v = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glGetInteger64i_v");
        this.glGetInteger64i_v = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glGetSynciv");
        this.glGetSynciv = functionAddress18;
        return z17 & (functionAddress18 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean GL33_initNativeFunctionAddresses(boolean r8) {
        /*
            Method dump skipped, instruction units count: 1426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.GL33_initNativeFunctionAddresses(boolean):boolean");
    }

    private boolean GL40_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlendEquationi");
        this.glBlendEquationi = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBlendEquationSeparatei");
        this.glBlendEquationSeparatei = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glBlendFunci");
        this.glBlendFunci = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBlendFuncSeparatei");
        this.glBlendFuncSeparatei = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glDrawArraysIndirect");
        this.glDrawArraysIndirect = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glDrawElementsIndirect");
        this.glDrawElementsIndirect = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glUniform1d");
        this.glUniform1d = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glUniform2d");
        this.glUniform2d = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glUniform3d");
        this.glUniform3d = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glUniform4d");
        this.glUniform4d = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glUniform1dv");
        this.glUniform1dv = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glUniform2dv");
        this.glUniform2dv = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glUniform3dv");
        this.glUniform3dv = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glUniform4dv");
        this.glUniform4dv = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glUniformMatrix2dv");
        this.glUniformMatrix2dv = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glUniformMatrix3dv");
        this.glUniformMatrix3dv = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glUniformMatrix4dv");
        this.glUniformMatrix4dv = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glUniformMatrix2x3dv");
        this.glUniformMatrix2x3dv = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glUniformMatrix2x4dv");
        this.glUniformMatrix2x4dv = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glUniformMatrix3x2dv");
        this.glUniformMatrix3x2dv = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glUniformMatrix3x4dv");
        this.glUniformMatrix3x4dv = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glUniformMatrix4x2dv");
        this.glUniformMatrix4x2dv = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glUniformMatrix4x3dv");
        this.glUniformMatrix4x3dv = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glGetUniformdv");
        this.glGetUniformdv = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glMinSampleShading");
        this.glMinSampleShading = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glGetSubroutineUniformLocation");
        this.glGetSubroutineUniformLocation = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glGetSubroutineIndex");
        this.glGetSubroutineIndex = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glGetActiveSubroutineUniformiv");
        this.glGetActiveSubroutineUniformiv = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glGetActiveSubroutineUniformName");
        this.glGetActiveSubroutineUniformName = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glGetActiveSubroutineName");
        this.glGetActiveSubroutineName = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glUniformSubroutinesuiv");
        this.glUniformSubroutinesuiv = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glGetUniformSubroutineuiv");
        this.glGetUniformSubroutineuiv = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glGetProgramStageiv");
        this.glGetProgramStageiv = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glPatchParameteri");
        this.glPatchParameteri = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glPatchParameterfv");
        this.glPatchParameterfv = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glBindTransformFeedback");
        this.glBindTransformFeedback = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glDeleteTransformFeedbacks");
        this.glDeleteTransformFeedbacks = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glGenTransformFeedbacks");
        this.glGenTransformFeedbacks = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glIsTransformFeedback");
        this.glIsTransformFeedback = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glPauseTransformFeedback");
        this.glPauseTransformFeedback = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glResumeTransformFeedback");
        this.glResumeTransformFeedback = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glDrawTransformFeedback");
        this.glDrawTransformFeedback = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glDrawTransformFeedbackStream");
        this.glDrawTransformFeedbackStream = functionAddress43;
        boolean z43 = z42 & (functionAddress43 != 0);
        long functionAddress44 = GLContext.getFunctionAddress("glBeginQueryIndexed");
        this.glBeginQueryIndexed = functionAddress44;
        boolean z44 = z43 & (functionAddress44 != 0);
        long functionAddress45 = GLContext.getFunctionAddress("glEndQueryIndexed");
        this.glEndQueryIndexed = functionAddress45;
        boolean z45 = z44 & (functionAddress45 != 0);
        long functionAddress46 = GLContext.getFunctionAddress("glGetQueryIndexediv");
        this.glGetQueryIndexediv = functionAddress46;
        return z45 & (functionAddress46 != 0);
    }

    private boolean GL41_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glReleaseShaderCompiler");
        this.glReleaseShaderCompiler = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glShaderBinary");
        this.glShaderBinary = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetShaderPrecisionFormat");
        this.glGetShaderPrecisionFormat = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glDepthRangef");
        this.glDepthRangef = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glClearDepthf");
        this.glClearDepthf = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetProgramBinary");
        this.glGetProgramBinary = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glProgramBinary");
        this.glProgramBinary = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glProgramParameteri");
        this.glProgramParameteri = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glUseProgramStages");
        this.glUseProgramStages = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glActiveShaderProgram");
        this.glActiveShaderProgram = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glCreateShaderProgramv");
        this.glCreateShaderProgramv = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glBindProgramPipeline");
        this.glBindProgramPipeline = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glDeleteProgramPipelines");
        this.glDeleteProgramPipelines = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glGenProgramPipelines");
        this.glGenProgramPipelines = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glIsProgramPipeline");
        this.glIsProgramPipeline = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glGetProgramPipelineiv");
        this.glGetProgramPipelineiv = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glProgramUniform1i");
        this.glProgramUniform1i = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glProgramUniform2i");
        this.glProgramUniform2i = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glProgramUniform3i");
        this.glProgramUniform3i = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glProgramUniform4i");
        this.glProgramUniform4i = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glProgramUniform1f");
        this.glProgramUniform1f = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glProgramUniform2f");
        this.glProgramUniform2f = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glProgramUniform3f");
        this.glProgramUniform3f = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glProgramUniform4f");
        this.glProgramUniform4f = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glProgramUniform1d");
        this.glProgramUniform1d = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glProgramUniform2d");
        this.glProgramUniform2d = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glProgramUniform3d");
        this.glProgramUniform3d = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glProgramUniform4d");
        this.glProgramUniform4d = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glProgramUniform1iv");
        this.glProgramUniform1iv = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glProgramUniform2iv");
        this.glProgramUniform2iv = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glProgramUniform3iv");
        this.glProgramUniform3iv = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glProgramUniform4iv");
        this.glProgramUniform4iv = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glProgramUniform1fv");
        this.glProgramUniform1fv = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glProgramUniform2fv");
        this.glProgramUniform2fv = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glProgramUniform3fv");
        this.glProgramUniform3fv = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glProgramUniform4fv");
        this.glProgramUniform4fv = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glProgramUniform1dv");
        this.glProgramUniform1dv = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glProgramUniform2dv");
        this.glProgramUniform2dv = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glProgramUniform3dv");
        this.glProgramUniform3dv = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glProgramUniform4dv");
        this.glProgramUniform4dv = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glProgramUniform1ui");
        this.glProgramUniform1ui = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glProgramUniform2ui");
        this.glProgramUniform2ui = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glProgramUniform3ui");
        this.glProgramUniform3ui = functionAddress43;
        boolean z43 = z42 & (functionAddress43 != 0);
        long functionAddress44 = GLContext.getFunctionAddress("glProgramUniform4ui");
        this.glProgramUniform4ui = functionAddress44;
        boolean z44 = z43 & (functionAddress44 != 0);
        long functionAddress45 = GLContext.getFunctionAddress("glProgramUniform1uiv");
        this.glProgramUniform1uiv = functionAddress45;
        boolean z45 = z44 & (functionAddress45 != 0);
        long functionAddress46 = GLContext.getFunctionAddress("glProgramUniform2uiv");
        this.glProgramUniform2uiv = functionAddress46;
        boolean z46 = z45 & (functionAddress46 != 0);
        long functionAddress47 = GLContext.getFunctionAddress("glProgramUniform3uiv");
        this.glProgramUniform3uiv = functionAddress47;
        boolean z47 = z46 & (functionAddress47 != 0);
        long functionAddress48 = GLContext.getFunctionAddress("glProgramUniform4uiv");
        this.glProgramUniform4uiv = functionAddress48;
        boolean z48 = z47 & (functionAddress48 != 0);
        long functionAddress49 = GLContext.getFunctionAddress("glProgramUniformMatrix2fv");
        this.glProgramUniformMatrix2fv = functionAddress49;
        boolean z49 = z48 & (functionAddress49 != 0);
        long functionAddress50 = GLContext.getFunctionAddress("glProgramUniformMatrix3fv");
        this.glProgramUniformMatrix3fv = functionAddress50;
        boolean z50 = z49 & (functionAddress50 != 0);
        long functionAddress51 = GLContext.getFunctionAddress("glProgramUniformMatrix4fv");
        this.glProgramUniformMatrix4fv = functionAddress51;
        boolean z51 = z50 & (functionAddress51 != 0);
        long functionAddress52 = GLContext.getFunctionAddress("glProgramUniformMatrix2dv");
        this.glProgramUniformMatrix2dv = functionAddress52;
        boolean z52 = z51 & (functionAddress52 != 0);
        long functionAddress53 = GLContext.getFunctionAddress("glProgramUniformMatrix3dv");
        this.glProgramUniformMatrix3dv = functionAddress53;
        boolean z53 = z52 & (functionAddress53 != 0);
        long functionAddress54 = GLContext.getFunctionAddress("glProgramUniformMatrix4dv");
        this.glProgramUniformMatrix4dv = functionAddress54;
        boolean z54 = z53 & (functionAddress54 != 0);
        long functionAddress55 = GLContext.getFunctionAddress("glProgramUniformMatrix2x3fv");
        this.glProgramUniformMatrix2x3fv = functionAddress55;
        boolean z55 = z54 & (functionAddress55 != 0);
        long functionAddress56 = GLContext.getFunctionAddress("glProgramUniformMatrix3x2fv");
        this.glProgramUniformMatrix3x2fv = functionAddress56;
        boolean z56 = z55 & (functionAddress56 != 0);
        long functionAddress57 = GLContext.getFunctionAddress("glProgramUniformMatrix2x4fv");
        this.glProgramUniformMatrix2x4fv = functionAddress57;
        boolean z57 = z56 & (functionAddress57 != 0);
        long functionAddress58 = GLContext.getFunctionAddress("glProgramUniformMatrix4x2fv");
        this.glProgramUniformMatrix4x2fv = functionAddress58;
        boolean z58 = z57 & (functionAddress58 != 0);
        long functionAddress59 = GLContext.getFunctionAddress("glProgramUniformMatrix3x4fv");
        this.glProgramUniformMatrix3x4fv = functionAddress59;
        boolean z59 = z58 & (functionAddress59 != 0);
        long functionAddress60 = GLContext.getFunctionAddress("glProgramUniformMatrix4x3fv");
        this.glProgramUniformMatrix4x3fv = functionAddress60;
        boolean z60 = z59 & (functionAddress60 != 0);
        long functionAddress61 = GLContext.getFunctionAddress("glProgramUniformMatrix2x3dv");
        this.glProgramUniformMatrix2x3dv = functionAddress61;
        boolean z61 = z60 & (functionAddress61 != 0);
        long functionAddress62 = GLContext.getFunctionAddress("glProgramUniformMatrix3x2dv");
        this.glProgramUniformMatrix3x2dv = functionAddress62;
        boolean z62 = z61 & (functionAddress62 != 0);
        long functionAddress63 = GLContext.getFunctionAddress("glProgramUniformMatrix2x4dv");
        this.glProgramUniformMatrix2x4dv = functionAddress63;
        boolean z63 = z62 & (functionAddress63 != 0);
        long functionAddress64 = GLContext.getFunctionAddress("glProgramUniformMatrix4x2dv");
        this.glProgramUniformMatrix4x2dv = functionAddress64;
        boolean z64 = z63 & (functionAddress64 != 0);
        long functionAddress65 = GLContext.getFunctionAddress("glProgramUniformMatrix3x4dv");
        this.glProgramUniformMatrix3x4dv = functionAddress65;
        boolean z65 = z64 & (functionAddress65 != 0);
        long functionAddress66 = GLContext.getFunctionAddress("glProgramUniformMatrix4x3dv");
        this.glProgramUniformMatrix4x3dv = functionAddress66;
        boolean z66 = z65 & (functionAddress66 != 0);
        long functionAddress67 = GLContext.getFunctionAddress("glValidateProgramPipeline");
        this.glValidateProgramPipeline = functionAddress67;
        boolean z67 = z66 & (functionAddress67 != 0);
        long functionAddress68 = GLContext.getFunctionAddress("glGetProgramPipelineInfoLog");
        this.glGetProgramPipelineInfoLog = functionAddress68;
        boolean z68 = z67 & (functionAddress68 != 0);
        long functionAddress69 = GLContext.getFunctionAddress("glVertexAttribL1d");
        this.glVertexAttribL1d = functionAddress69;
        boolean z69 = z68 & (functionAddress69 != 0);
        long functionAddress70 = GLContext.getFunctionAddress("glVertexAttribL2d");
        this.glVertexAttribL2d = functionAddress70;
        boolean z70 = z69 & (functionAddress70 != 0);
        long functionAddress71 = GLContext.getFunctionAddress("glVertexAttribL3d");
        this.glVertexAttribL3d = functionAddress71;
        boolean z71 = z70 & (functionAddress71 != 0);
        long functionAddress72 = GLContext.getFunctionAddress("glVertexAttribL4d");
        this.glVertexAttribL4d = functionAddress72;
        boolean z72 = z71 & (functionAddress72 != 0);
        long functionAddress73 = GLContext.getFunctionAddress("glVertexAttribL1dv");
        this.glVertexAttribL1dv = functionAddress73;
        boolean z73 = z72 & (functionAddress73 != 0);
        long functionAddress74 = GLContext.getFunctionAddress("glVertexAttribL2dv");
        this.glVertexAttribL2dv = functionAddress74;
        boolean z74 = z73 & (functionAddress74 != 0);
        long functionAddress75 = GLContext.getFunctionAddress("glVertexAttribL3dv");
        this.glVertexAttribL3dv = functionAddress75;
        boolean z75 = z74 & (functionAddress75 != 0);
        long functionAddress76 = GLContext.getFunctionAddress("glVertexAttribL4dv");
        this.glVertexAttribL4dv = functionAddress76;
        boolean z76 = z75 & (functionAddress76 != 0);
        long functionAddress77 = GLContext.getFunctionAddress("glVertexAttribLPointer");
        this.glVertexAttribLPointer = functionAddress77;
        boolean z77 = z76 & (functionAddress77 != 0);
        long functionAddress78 = GLContext.getFunctionAddress("glGetVertexAttribLdv");
        this.glGetVertexAttribLdv = functionAddress78;
        boolean z78 = z77 & (functionAddress78 != 0);
        long functionAddress79 = GLContext.getFunctionAddress("glViewportArrayv");
        this.glViewportArrayv = functionAddress79;
        boolean z79 = z78 & (functionAddress79 != 0);
        long functionAddress80 = GLContext.getFunctionAddress("glViewportIndexedf");
        this.glViewportIndexedf = functionAddress80;
        boolean z80 = z79 & (functionAddress80 != 0);
        long functionAddress81 = GLContext.getFunctionAddress("glViewportIndexedfv");
        this.glViewportIndexedfv = functionAddress81;
        boolean z81 = z80 & (functionAddress81 != 0);
        long functionAddress82 = GLContext.getFunctionAddress("glScissorArrayv");
        this.glScissorArrayv = functionAddress82;
        boolean z82 = z81 & (functionAddress82 != 0);
        long functionAddress83 = GLContext.getFunctionAddress("glScissorIndexed");
        this.glScissorIndexed = functionAddress83;
        boolean z83 = z82 & (functionAddress83 != 0);
        long functionAddress84 = GLContext.getFunctionAddress("glScissorIndexedv");
        this.glScissorIndexedv = functionAddress84;
        boolean z84 = z83 & (functionAddress84 != 0);
        long functionAddress85 = GLContext.getFunctionAddress("glDepthRangeArrayv");
        this.glDepthRangeArrayv = functionAddress85;
        boolean z85 = z84 & (functionAddress85 != 0);
        long functionAddress86 = GLContext.getFunctionAddress("glDepthRangeIndexed");
        this.glDepthRangeIndexed = functionAddress86;
        boolean z86 = z85 & (functionAddress86 != 0);
        long functionAddress87 = GLContext.getFunctionAddress("glGetFloati_v");
        this.glGetFloati_v = functionAddress87;
        boolean z87 = z86 & (functionAddress87 != 0);
        long functionAddress88 = GLContext.getFunctionAddress("glGetDoublei_v");
        this.glGetDoublei_v = functionAddress88;
        return z87 & (functionAddress88 != 0);
    }

    private boolean GL42_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetActiveAtomicCounterBufferiv");
        this.glGetActiveAtomicCounterBufferiv = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glTexStorage1D");
        this.glTexStorage1D = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glTexStorage2D");
        this.glTexStorage2D = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glTexStorage3D");
        this.glTexStorage3D = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glDrawTransformFeedbackInstanced");
        this.glDrawTransformFeedbackInstanced = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glDrawTransformFeedbackStreamInstanced");
        this.glDrawTransformFeedbackStreamInstanced = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glDrawArraysInstancedBaseInstance");
        this.glDrawArraysInstancedBaseInstance = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glDrawElementsInstancedBaseInstance");
        this.glDrawElementsInstancedBaseInstance = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glDrawElementsInstancedBaseVertexBaseInstance");
        this.glDrawElementsInstancedBaseVertexBaseInstance = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glBindImageTexture");
        this.glBindImageTexture = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glMemoryBarrier");
        this.glMemoryBarrier = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glGetInternalformativ");
        this.glGetInternalformativ = functionAddress12;
        return z11 & (functionAddress12 != 0);
    }

    private boolean GL43_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glClearBufferData");
        this.glClearBufferData = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glClearBufferSubData");
        this.glClearBufferSubData = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDispatchCompute");
        this.glDispatchCompute = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glDispatchComputeIndirect");
        this.glDispatchComputeIndirect = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glCopyImageSubData");
        this.glCopyImageSubData = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glDebugMessageControl");
        this.glDebugMessageControl = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glDebugMessageInsert");
        this.glDebugMessageInsert = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glDebugMessageCallback");
        this.glDebugMessageCallback = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetDebugMessageLog");
        this.glGetDebugMessageLog = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glPushDebugGroup");
        this.glPushDebugGroup = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glPopDebugGroup");
        this.glPopDebugGroup = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glObjectLabel");
        this.glObjectLabel = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glGetObjectLabel");
        this.glGetObjectLabel = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glObjectPtrLabel");
        this.glObjectPtrLabel = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glGetObjectPtrLabel");
        this.glGetObjectPtrLabel = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glFramebufferParameteri");
        this.glFramebufferParameteri = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glGetFramebufferParameteriv");
        this.glGetFramebufferParameteriv = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glGetInternalformati64v");
        this.glGetInternalformati64v = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glInvalidateTexSubImage");
        this.glInvalidateTexSubImage = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glInvalidateTexImage");
        this.glInvalidateTexImage = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glInvalidateBufferSubData");
        this.glInvalidateBufferSubData = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glInvalidateBufferData");
        this.glInvalidateBufferData = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glInvalidateFramebuffer");
        this.glInvalidateFramebuffer = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glInvalidateSubFramebuffer");
        this.glInvalidateSubFramebuffer = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glMultiDrawArraysIndirect");
        this.glMultiDrawArraysIndirect = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glMultiDrawElementsIndirect");
        this.glMultiDrawElementsIndirect = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glGetProgramInterfaceiv");
        this.glGetProgramInterfaceiv = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glGetProgramResourceIndex");
        this.glGetProgramResourceIndex = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glGetProgramResourceName");
        this.glGetProgramResourceName = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glGetProgramResourceiv");
        this.glGetProgramResourceiv = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glGetProgramResourceLocation");
        this.glGetProgramResourceLocation = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glGetProgramResourceLocationIndex");
        this.glGetProgramResourceLocationIndex = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glShaderStorageBlockBinding");
        this.glShaderStorageBlockBinding = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glTexBufferRange");
        this.glTexBufferRange = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glTexStorage2DMultisample");
        this.glTexStorage2DMultisample = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glTexStorage3DMultisample");
        this.glTexStorage3DMultisample = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glTextureView");
        this.glTextureView = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glBindVertexBuffer");
        this.glBindVertexBuffer = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glVertexAttribFormat");
        this.glVertexAttribFormat = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glVertexAttribIFormat");
        this.glVertexAttribIFormat = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glVertexAttribLFormat");
        this.glVertexAttribLFormat = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glVertexAttribBinding");
        this.glVertexAttribBinding = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glVertexBindingDivisor");
        this.glVertexBindingDivisor = functionAddress43;
        return z42 & (functionAddress43 != 0);
    }

    private boolean GL44_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBufferStorage");
        this.glBufferStorage = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glClearTexImage");
        this.glClearTexImage = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glClearTexSubImage");
        this.glClearTexSubImage = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBindBuffersBase");
        this.glBindBuffersBase = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glBindBuffersRange");
        this.glBindBuffersRange = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glBindTextures");
        this.glBindTextures = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glBindSamplers");
        this.glBindSamplers = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glBindImageTextures");
        this.glBindImageTextures = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glBindVertexBuffers");
        this.glBindVertexBuffers = functionAddress9;
        return z8 & (functionAddress9 != 0);
    }

    private boolean GL45_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glClipControl");
        this.glClipControl = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glCreateTransformFeedbacks");
        this.glCreateTransformFeedbacks = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glTransformFeedbackBufferBase");
        this.glTransformFeedbackBufferBase = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glTransformFeedbackBufferRange");
        this.glTransformFeedbackBufferRange = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetTransformFeedbackiv");
        this.glGetTransformFeedbackiv = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetTransformFeedbacki_v");
        this.glGetTransformFeedbacki_v = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetTransformFeedbacki64_v");
        this.glGetTransformFeedbacki64_v = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glCreateBuffers");
        this.glCreateBuffers = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glNamedBufferStorage");
        this.glNamedBufferStorage = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glNamedBufferData");
        this.glNamedBufferData = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glNamedBufferSubData");
        this.glNamedBufferSubData = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glCopyNamedBufferSubData");
        this.glCopyNamedBufferSubData = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glClearNamedBufferData");
        this.glClearNamedBufferData = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glClearNamedBufferSubData");
        this.glClearNamedBufferSubData = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glMapNamedBuffer");
        this.glMapNamedBuffer = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glMapNamedBufferRange");
        this.glMapNamedBufferRange = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glUnmapNamedBuffer");
        this.glUnmapNamedBuffer = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glFlushMappedNamedBufferRange");
        this.glFlushMappedNamedBufferRange = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glGetNamedBufferParameteriv");
        this.glGetNamedBufferParameteriv = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glGetNamedBufferParameteri64v");
        this.glGetNamedBufferParameteri64v = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glGetNamedBufferPointerv");
        this.glGetNamedBufferPointerv = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glGetNamedBufferSubData");
        this.glGetNamedBufferSubData = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glCreateFramebuffers");
        this.glCreateFramebuffers = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glNamedFramebufferRenderbuffer");
        this.glNamedFramebufferRenderbuffer = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glNamedFramebufferParameteri");
        this.glNamedFramebufferParameteri = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glNamedFramebufferTexture");
        this.glNamedFramebufferTexture = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glNamedFramebufferTextureLayer");
        this.glNamedFramebufferTextureLayer = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glNamedFramebufferDrawBuffer");
        this.glNamedFramebufferDrawBuffer = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glNamedFramebufferDrawBuffers");
        this.glNamedFramebufferDrawBuffers = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glNamedFramebufferReadBuffer");
        this.glNamedFramebufferReadBuffer = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glInvalidateNamedFramebufferData");
        this.glInvalidateNamedFramebufferData = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glInvalidateNamedFramebufferSubData");
        this.glInvalidateNamedFramebufferSubData = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glClearNamedFramebufferiv");
        this.glClearNamedFramebufferiv = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glClearNamedFramebufferuiv");
        this.glClearNamedFramebufferuiv = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glClearNamedFramebufferfv");
        this.glClearNamedFramebufferfv = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glClearNamedFramebufferfi");
        this.glClearNamedFramebufferfi = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glBlitNamedFramebuffer");
        this.glBlitNamedFramebuffer = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glCheckNamedFramebufferStatus");
        this.glCheckNamedFramebufferStatus = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glGetNamedFramebufferParameteriv");
        this.glGetNamedFramebufferParameteriv = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glGetNamedFramebufferAttachmentParameteriv");
        this.glGetNamedFramebufferAttachmentParameteriv = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glCreateRenderbuffers");
        this.glCreateRenderbuffers = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glNamedRenderbufferStorage");
        this.glNamedRenderbufferStorage = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glNamedRenderbufferStorageMultisample");
        this.glNamedRenderbufferStorageMultisample = functionAddress43;
        boolean z43 = z42 & (functionAddress43 != 0);
        long functionAddress44 = GLContext.getFunctionAddress("glGetNamedRenderbufferParameteriv");
        this.glGetNamedRenderbufferParameteriv = functionAddress44;
        boolean z44 = z43 & (functionAddress44 != 0);
        long functionAddress45 = GLContext.getFunctionAddress("glCreateTextures");
        this.glCreateTextures = functionAddress45;
        boolean z45 = z44 & (functionAddress45 != 0);
        long functionAddress46 = GLContext.getFunctionAddress("glTextureBuffer");
        this.glTextureBuffer = functionAddress46;
        boolean z46 = z45 & (functionAddress46 != 0);
        long functionAddress47 = GLContext.getFunctionAddress("glTextureBufferRange");
        this.glTextureBufferRange = functionAddress47;
        boolean z47 = z46 & (functionAddress47 != 0);
        long functionAddress48 = GLContext.getFunctionAddress("glTextureStorage1D");
        this.glTextureStorage1D = functionAddress48;
        boolean z48 = z47 & (functionAddress48 != 0);
        long functionAddress49 = GLContext.getFunctionAddress("glTextureStorage2D");
        this.glTextureStorage2D = functionAddress49;
        boolean z49 = z48 & (functionAddress49 != 0);
        long functionAddress50 = GLContext.getFunctionAddress("glTextureStorage3D");
        this.glTextureStorage3D = functionAddress50;
        boolean z50 = z49 & (functionAddress50 != 0);
        long functionAddress51 = GLContext.getFunctionAddress("glTextureStorage2DMultisample");
        this.glTextureStorage2DMultisample = functionAddress51;
        boolean z51 = z50 & (functionAddress51 != 0);
        long functionAddress52 = GLContext.getFunctionAddress("glTextureStorage3DMultisample");
        this.glTextureStorage3DMultisample = functionAddress52;
        boolean z52 = z51 & (functionAddress52 != 0);
        long functionAddress53 = GLContext.getFunctionAddress("glTextureSubImage1D");
        this.glTextureSubImage1D = functionAddress53;
        boolean z53 = z52 & (functionAddress53 != 0);
        long functionAddress54 = GLContext.getFunctionAddress("glTextureSubImage2D");
        this.glTextureSubImage2D = functionAddress54;
        boolean z54 = z53 & (functionAddress54 != 0);
        long functionAddress55 = GLContext.getFunctionAddress("glTextureSubImage3D");
        this.glTextureSubImage3D = functionAddress55;
        boolean z55 = z54 & (functionAddress55 != 0);
        long functionAddress56 = GLContext.getFunctionAddress("glCompressedTextureSubImage1D");
        this.glCompressedTextureSubImage1D = functionAddress56;
        boolean z56 = z55 & (functionAddress56 != 0);
        long functionAddress57 = GLContext.getFunctionAddress("glCompressedTextureSubImage2D");
        this.glCompressedTextureSubImage2D = functionAddress57;
        boolean z57 = z56 & (functionAddress57 != 0);
        long functionAddress58 = GLContext.getFunctionAddress("glCompressedTextureSubImage3D");
        this.glCompressedTextureSubImage3D = functionAddress58;
        boolean z58 = z57 & (functionAddress58 != 0);
        long functionAddress59 = GLContext.getFunctionAddress("glCopyTextureSubImage1D");
        this.glCopyTextureSubImage1D = functionAddress59;
        boolean z59 = z58 & (functionAddress59 != 0);
        long functionAddress60 = GLContext.getFunctionAddress("glCopyTextureSubImage2D");
        this.glCopyTextureSubImage2D = functionAddress60;
        boolean z60 = z59 & (functionAddress60 != 0);
        long functionAddress61 = GLContext.getFunctionAddress("glCopyTextureSubImage3D");
        this.glCopyTextureSubImage3D = functionAddress61;
        boolean z61 = z60 & (functionAddress61 != 0);
        long functionAddress62 = GLContext.getFunctionAddress("glTextureParameterf");
        this.glTextureParameterf = functionAddress62;
        boolean z62 = z61 & (functionAddress62 != 0);
        long functionAddress63 = GLContext.getFunctionAddress("glTextureParameterfv");
        this.glTextureParameterfv = functionAddress63;
        boolean z63 = z62 & (functionAddress63 != 0);
        long functionAddress64 = GLContext.getFunctionAddress("glTextureParameteri");
        this.glTextureParameteri = functionAddress64;
        boolean z64 = z63 & (functionAddress64 != 0);
        long functionAddress65 = GLContext.getFunctionAddress("glTextureParameterIiv");
        this.glTextureParameterIiv = functionAddress65;
        boolean z65 = z64 & (functionAddress65 != 0);
        long functionAddress66 = GLContext.getFunctionAddress("glTextureParameterIuiv");
        this.glTextureParameterIuiv = functionAddress66;
        boolean z66 = z65 & (functionAddress66 != 0);
        long functionAddress67 = GLContext.getFunctionAddress("glTextureParameteriv");
        this.glTextureParameteriv = functionAddress67;
        boolean z67 = z66 & (functionAddress67 != 0);
        long functionAddress68 = GLContext.getFunctionAddress("glGenerateTextureMipmap");
        this.glGenerateTextureMipmap = functionAddress68;
        boolean z68 = z67 & (functionAddress68 != 0);
        long functionAddress69 = GLContext.getFunctionAddress("glBindTextureUnit");
        this.glBindTextureUnit = functionAddress69;
        boolean z69 = z68 & (functionAddress69 != 0);
        long functionAddress70 = GLContext.getFunctionAddress("glGetTextureImage");
        this.glGetTextureImage = functionAddress70;
        boolean z70 = z69 & (functionAddress70 != 0);
        long functionAddress71 = GLContext.getFunctionAddress("glGetCompressedTextureImage");
        this.glGetCompressedTextureImage = functionAddress71;
        boolean z71 = z70 & (functionAddress71 != 0);
        long functionAddress72 = GLContext.getFunctionAddress("glGetTextureLevelParameterfv");
        this.glGetTextureLevelParameterfv = functionAddress72;
        boolean z72 = z71 & (functionAddress72 != 0);
        long functionAddress73 = GLContext.getFunctionAddress("glGetTextureLevelParameteriv");
        this.glGetTextureLevelParameteriv = functionAddress73;
        boolean z73 = z72 & (functionAddress73 != 0);
        long functionAddress74 = GLContext.getFunctionAddress("glGetTextureParameterfv");
        this.glGetTextureParameterfv = functionAddress74;
        boolean z74 = z73 & (functionAddress74 != 0);
        long functionAddress75 = GLContext.getFunctionAddress("glGetTextureParameterIiv");
        this.glGetTextureParameterIiv = functionAddress75;
        boolean z75 = z74 & (functionAddress75 != 0);
        long functionAddress76 = GLContext.getFunctionAddress("glGetTextureParameterIuiv");
        this.glGetTextureParameterIuiv = functionAddress76;
        boolean z76 = z75 & (functionAddress76 != 0);
        long functionAddress77 = GLContext.getFunctionAddress("glGetTextureParameteriv");
        this.glGetTextureParameteriv = functionAddress77;
        boolean z77 = z76 & (functionAddress77 != 0);
        long functionAddress78 = GLContext.getFunctionAddress("glCreateVertexArrays");
        this.glCreateVertexArrays = functionAddress78;
        boolean z78 = z77 & (functionAddress78 != 0);
        long functionAddress79 = GLContext.getFunctionAddress("glDisableVertexArrayAttrib");
        this.glDisableVertexArrayAttrib = functionAddress79;
        boolean z79 = z78 & (functionAddress79 != 0);
        long functionAddress80 = GLContext.getFunctionAddress("glEnableVertexArrayAttrib");
        this.glEnableVertexArrayAttrib = functionAddress80;
        boolean z80 = z79 & (functionAddress80 != 0);
        long functionAddress81 = GLContext.getFunctionAddress("glVertexArrayElementBuffer");
        this.glVertexArrayElementBuffer = functionAddress81;
        boolean z81 = z80 & (functionAddress81 != 0);
        long functionAddress82 = GLContext.getFunctionAddress("glVertexArrayVertexBuffer");
        this.glVertexArrayVertexBuffer = functionAddress82;
        boolean z82 = z81 & (functionAddress82 != 0);
        long functionAddress83 = GLContext.getFunctionAddress("glVertexArrayVertexBuffers");
        this.glVertexArrayVertexBuffers = functionAddress83;
        boolean z83 = z82 & (functionAddress83 != 0);
        long functionAddress84 = GLContext.getFunctionAddress("glVertexArrayAttribFormat");
        this.glVertexArrayAttribFormat = functionAddress84;
        boolean z84 = z83 & (functionAddress84 != 0);
        long functionAddress85 = GLContext.getFunctionAddress("glVertexArrayAttribIFormat");
        this.glVertexArrayAttribIFormat = functionAddress85;
        boolean z85 = z84 & (functionAddress85 != 0);
        long functionAddress86 = GLContext.getFunctionAddress("glVertexArrayAttribLFormat");
        this.glVertexArrayAttribLFormat = functionAddress86;
        boolean z86 = z85 & (functionAddress86 != 0);
        long functionAddress87 = GLContext.getFunctionAddress("glVertexArrayAttribBinding");
        this.glVertexArrayAttribBinding = functionAddress87;
        boolean z87 = z86 & (functionAddress87 != 0);
        long functionAddress88 = GLContext.getFunctionAddress("glVertexArrayBindingDivisor");
        this.glVertexArrayBindingDivisor = functionAddress88;
        boolean z88 = z87 & (functionAddress88 != 0);
        long functionAddress89 = GLContext.getFunctionAddress("glGetVertexArrayiv");
        this.glGetVertexArrayiv = functionAddress89;
        boolean z89 = z88 & (functionAddress89 != 0);
        long functionAddress90 = GLContext.getFunctionAddress("glGetVertexArrayIndexediv");
        this.glGetVertexArrayIndexediv = functionAddress90;
        boolean z90 = z89 & (functionAddress90 != 0);
        long functionAddress91 = GLContext.getFunctionAddress("glGetVertexArrayIndexed64iv");
        this.glGetVertexArrayIndexed64iv = functionAddress91;
        boolean z91 = z90 & (functionAddress91 != 0);
        long functionAddress92 = GLContext.getFunctionAddress("glCreateSamplers");
        this.glCreateSamplers = functionAddress92;
        boolean z92 = z91 & (functionAddress92 != 0);
        long functionAddress93 = GLContext.getFunctionAddress("glCreateProgramPipelines");
        this.glCreateProgramPipelines = functionAddress93;
        boolean z93 = z92 & (functionAddress93 != 0);
        long functionAddress94 = GLContext.getFunctionAddress("glCreateQueries");
        this.glCreateQueries = functionAddress94;
        boolean z94 = z93 & (functionAddress94 != 0);
        long functionAddress95 = GLContext.getFunctionAddress("glMemoryBarrierByRegion");
        this.glMemoryBarrierByRegion = functionAddress95;
        boolean z95 = z94 & (functionAddress95 != 0);
        long functionAddress96 = GLContext.getFunctionAddress("glGetTextureSubImage");
        this.glGetTextureSubImage = functionAddress96;
        boolean z96 = z95 & (functionAddress96 != 0);
        long functionAddress97 = GLContext.getFunctionAddress("glGetCompressedTextureSubImage");
        this.glGetCompressedTextureSubImage = functionAddress97;
        boolean z97 = z96 & (functionAddress97 != 0);
        long functionAddress98 = GLContext.getFunctionAddress("glTextureBarrier");
        this.glTextureBarrier = functionAddress98;
        boolean z98 = z97 & (functionAddress98 != 0);
        long functionAddress99 = GLContext.getFunctionAddress("glGetGraphicsResetStatus");
        this.glGetGraphicsResetStatus = functionAddress99;
        boolean z99 = z98 & (functionAddress99 != 0);
        long functionAddress100 = GLContext.getFunctionAddress("glReadnPixels");
        this.glReadnPixels = functionAddress100;
        boolean z100 = z99 & (functionAddress100 != 0);
        long functionAddress101 = GLContext.getFunctionAddress("glGetnUniformfv");
        this.glGetnUniformfv = functionAddress101;
        boolean z101 = z100 & (functionAddress101 != 0);
        long functionAddress102 = GLContext.getFunctionAddress("glGetnUniformiv");
        this.glGetnUniformiv = functionAddress102;
        boolean z102 = z101 & (functionAddress102 != 0);
        long functionAddress103 = GLContext.getFunctionAddress("glGetnUniformuiv");
        this.glGetnUniformuiv = functionAddress103;
        return z102 & (functionAddress103 != 0);
    }

    private boolean GREMEDY_frame_terminator_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glFrameTerminatorGREMEDY");
        this.glFrameTerminatorGREMEDY = functionAddress;
        return functionAddress != 0;
    }

    private boolean GREMEDY_string_marker_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glStringMarkerGREMEDY");
        this.glStringMarkerGREMEDY = functionAddress;
        return functionAddress != 0;
    }

    private boolean INTEL_map_texture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMapTexture2DINTEL");
        this.glMapTexture2DINTEL = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glUnmapTexture2DINTEL");
        this.glUnmapTexture2DINTEL = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glSyncTextureINTEL");
        this.glSyncTextureINTEL = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean KHR_debug_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDebugMessageControl");
        this.glDebugMessageControl = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDebugMessageInsert");
        this.glDebugMessageInsert = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDebugMessageCallback");
        this.glDebugMessageCallback = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetDebugMessageLog");
        this.glGetDebugMessageLog = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glPushDebugGroup");
        this.glPushDebugGroup = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glPopDebugGroup");
        this.glPopDebugGroup = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glObjectLabel");
        this.glObjectLabel = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetObjectLabel");
        this.glGetObjectLabel = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glObjectPtrLabel");
        this.glObjectPtrLabel = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glGetObjectPtrLabel");
        this.glGetObjectPtrLabel = functionAddress10;
        return z9 & (functionAddress10 != 0);
    }

    private boolean KHR_robustness_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetGraphicsResetStatus");
        this.glGetGraphicsResetStatus = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glReadnPixels");
        this.glReadnPixels = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetnUniformfv");
        this.glGetnUniformfv = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetnUniformiv");
        this.glGetnUniformiv = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetnUniformuiv");
        this.glGetnUniformuiv = functionAddress5;
        return z4 & (functionAddress5 != 0);
    }

    private boolean NV_bindless_multi_draw_indirect_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMultiDrawArraysIndirectBindlessNV");
        this.glMultiDrawArraysIndirectBindlessNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMultiDrawElementsIndirectBindlessNV");
        this.glMultiDrawElementsIndirectBindlessNV = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean NV_bindless_texture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetTextureHandleNV");
        this.glGetTextureHandleNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetTextureSamplerHandleNV");
        this.glGetTextureSamplerHandleNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glMakeTextureHandleResidentNV");
        this.glMakeTextureHandleResidentNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glMakeTextureHandleNonResidentNV");
        this.glMakeTextureHandleNonResidentNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetImageHandleNV");
        this.glGetImageHandleNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glMakeImageHandleResidentNV");
        this.glMakeImageHandleResidentNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glMakeImageHandleNonResidentNV");
        this.glMakeImageHandleNonResidentNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glUniformHandleui64NV");
        this.glUniformHandleui64NV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glUniformHandleui64vNV");
        this.glUniformHandleui64vNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glProgramUniformHandleui64NV");
        this.glProgramUniformHandleui64NV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glProgramUniformHandleui64vNV");
        this.glProgramUniformHandleui64vNV = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glIsTextureHandleResidentNV");
        this.glIsTextureHandleResidentNV = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glIsImageHandleResidentNV");
        this.glIsImageHandleResidentNV = functionAddress13;
        return z12 & (functionAddress13 != 0);
    }

    private boolean NV_blend_equation_advanced_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBlendParameteriNV");
        this.glBlendParameteriNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBlendBarrierNV");
        this.glBlendBarrierNV = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean NV_conditional_render_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBeginConditionalRenderNV");
        this.glBeginConditionalRenderNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glEndConditionalRenderNV");
        this.glEndConditionalRenderNV = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean NV_copy_image_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCopyImageSubDataNV");
        this.glCopyImageSubDataNV = functionAddress;
        return functionAddress != 0;
    }

    private boolean NV_depth_buffer_float_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDepthRangedNV");
        this.glDepthRangedNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glClearDepthdNV");
        this.glClearDepthdNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDepthBoundsdNV");
        this.glDepthBoundsdNV = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean NV_draw_texture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glDrawTextureNV");
        this.glDrawTextureNV = functionAddress;
        return functionAddress != 0;
    }

    private boolean NV_evaluators_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetMapControlPointsNV");
        this.glGetMapControlPointsNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMapControlPointsNV");
        this.glMapControlPointsNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glMapParameterfvNV");
        this.glMapParameterfvNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glMapParameterivNV");
        this.glMapParameterivNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetMapParameterfvNV");
        this.glGetMapParameterfvNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetMapParameterivNV");
        this.glGetMapParameterivNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetMapAttribParameterfvNV");
        this.glGetMapAttribParameterfvNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetMapAttribParameterivNV");
        this.glGetMapAttribParameterivNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glEvalMapsNV");
        this.glEvalMapsNV = functionAddress9;
        return z8 & (functionAddress9 != 0);
    }

    private boolean NV_explicit_multisample_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGetBooleanIndexedvEXT");
        this.glGetBooleanIndexedvEXT = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetIntegerIndexedvEXT");
        this.glGetIntegerIndexedvEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetMultisamplefvNV");
        this.glGetMultisamplefvNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glSampleMaskIndexedNV");
        this.glSampleMaskIndexedNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glTexRenderbufferNV");
        this.glTexRenderbufferNV = functionAddress5;
        return z4 & (functionAddress5 != 0);
    }

    private boolean NV_fence_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGenFencesNV");
        this.glGenFencesNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteFencesNV");
        this.glDeleteFencesNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glSetFenceNV");
        this.glSetFenceNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glTestFenceNV");
        this.glTestFenceNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glFinishFenceNV");
        this.glFinishFenceNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glIsFenceNV");
        this.glIsFenceNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetFenceivNV");
        this.glGetFenceivNV = functionAddress7;
        return z6 & (functionAddress7 != 0);
    }

    private boolean NV_fragment_program_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProgramNamedParameter4fNV");
        this.glProgramNamedParameter4fNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glProgramNamedParameter4dNV");
        this.glProgramNamedParameter4dNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetProgramNamedParameterfvNV");
        this.glGetProgramNamedParameterfvNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetProgramNamedParameterdvNV");
        this.glGetProgramNamedParameterdvNV = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean NV_framebuffer_multisample_coverage_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glRenderbufferStorageMultisampleCoverageNV");
        this.glRenderbufferStorageMultisampleCoverageNV = functionAddress;
        return functionAddress != 0;
    }

    private boolean NV_geometry_program4_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProgramVertexLimitNV");
        this.glProgramVertexLimitNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFramebufferTextureEXT");
        this.glFramebufferTextureEXT = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glFramebufferTextureLayerEXT");
        this.glFramebufferTextureLayerEXT = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glFramebufferTextureFaceEXT");
        this.glFramebufferTextureFaceEXT = functionAddress4;
        return z3 & (functionAddress4 != 0);
    }

    private boolean NV_gpu_program4_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProgramLocalParameterI4iNV");
        this.glProgramLocalParameterI4iNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glProgramLocalParameterI4ivNV");
        this.glProgramLocalParameterI4ivNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glProgramLocalParametersI4ivNV");
        this.glProgramLocalParametersI4ivNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glProgramLocalParameterI4uiNV");
        this.glProgramLocalParameterI4uiNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glProgramLocalParameterI4uivNV");
        this.glProgramLocalParameterI4uivNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glProgramLocalParametersI4uivNV");
        this.glProgramLocalParametersI4uivNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glProgramEnvParameterI4iNV");
        this.glProgramEnvParameterI4iNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glProgramEnvParameterI4ivNV");
        this.glProgramEnvParameterI4ivNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glProgramEnvParametersI4ivNV");
        this.glProgramEnvParametersI4ivNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glProgramEnvParameterI4uiNV");
        this.glProgramEnvParameterI4uiNV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glProgramEnvParameterI4uivNV");
        this.glProgramEnvParameterI4uivNV = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glProgramEnvParametersI4uivNV");
        this.glProgramEnvParametersI4uivNV = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glGetProgramLocalParameterIivNV");
        this.glGetProgramLocalParameterIivNV = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glGetProgramLocalParameterIuivNV");
        this.glGetProgramLocalParameterIuivNV = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glGetProgramEnvParameterIivNV");
        this.glGetProgramEnvParameterIivNV = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glGetProgramEnvParameterIuivNV");
        this.glGetProgramEnvParameterIuivNV = functionAddress16;
        return z15 & (functionAddress16 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0209  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean NV_gpu_shader5_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 924
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.NV_gpu_shader5_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x021b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean NV_half_float_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 682
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.NV_half_float_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean NV_occlusion_query_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glGenOcclusionQueriesNV");
        this.glGenOcclusionQueriesNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteOcclusionQueriesNV");
        this.glDeleteOcclusionQueriesNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glIsOcclusionQueryNV");
        this.glIsOcclusionQueryNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glBeginOcclusionQueryNV");
        this.glBeginOcclusionQueryNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glEndOcclusionQueryNV");
        this.glEndOcclusionQueryNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetOcclusionQueryuivNV");
        this.glGetOcclusionQueryuivNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetOcclusionQueryivNV");
        this.glGetOcclusionQueryivNV = functionAddress7;
        return z6 & (functionAddress7 != 0);
    }

    private boolean NV_parameter_buffer_object_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glProgramBufferParametersfvNV");
        this.glProgramBufferParametersfvNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glProgramBufferParametersIivNV");
        this.glProgramBufferParametersIivNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glProgramBufferParametersIuivNV");
        this.glProgramBufferParametersIuivNV = functionAddress3;
        return z2 & (functionAddress3 != 0);
    }

    private boolean NV_path_rendering_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPathCommandsNV");
        this.glPathCommandsNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glPathCoordsNV");
        this.glPathCoordsNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glPathSubCommandsNV");
        this.glPathSubCommandsNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glPathSubCoordsNV");
        this.glPathSubCoordsNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glPathStringNV");
        this.glPathStringNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glPathGlyphsNV");
        this.glPathGlyphsNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glPathGlyphRangeNV");
        this.glPathGlyphRangeNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glWeightPathsNV");
        this.glWeightPathsNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glCopyPathNV");
        this.glCopyPathNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glInterpolatePathsNV");
        this.glInterpolatePathsNV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glTransformPathNV");
        this.glTransformPathNV = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glPathParameterivNV");
        this.glPathParameterivNV = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glPathParameteriNV");
        this.glPathParameteriNV = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glPathParameterfvNV");
        this.glPathParameterfvNV = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glPathParameterfNV");
        this.glPathParameterfNV = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glPathDashArrayNV");
        this.glPathDashArrayNV = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glGenPathsNV");
        this.glGenPathsNV = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glDeletePathsNV");
        this.glDeletePathsNV = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glIsPathNV");
        this.glIsPathNV = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glPathStencilFuncNV");
        this.glPathStencilFuncNV = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glPathStencilDepthOffsetNV");
        this.glPathStencilDepthOffsetNV = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glStencilFillPathNV");
        this.glStencilFillPathNV = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glStencilStrokePathNV");
        this.glStencilStrokePathNV = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glStencilFillPathInstancedNV");
        this.glStencilFillPathInstancedNV = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glStencilStrokePathInstancedNV");
        this.glStencilStrokePathInstancedNV = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glPathCoverDepthFuncNV");
        this.glPathCoverDepthFuncNV = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glPathColorGenNV");
        this.glPathColorGenNV = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glPathTexGenNV");
        this.glPathTexGenNV = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glPathFogGenNV");
        this.glPathFogGenNV = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glCoverFillPathNV");
        this.glCoverFillPathNV = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glCoverStrokePathNV");
        this.glCoverStrokePathNV = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glCoverFillPathInstancedNV");
        this.glCoverFillPathInstancedNV = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glCoverStrokePathInstancedNV");
        this.glCoverStrokePathInstancedNV = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glGetPathParameterivNV");
        this.glGetPathParameterivNV = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glGetPathParameterfvNV");
        this.glGetPathParameterfvNV = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glGetPathCommandsNV");
        this.glGetPathCommandsNV = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glGetPathCoordsNV");
        this.glGetPathCoordsNV = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glGetPathDashArrayNV");
        this.glGetPathDashArrayNV = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glGetPathMetricsNV");
        this.glGetPathMetricsNV = functionAddress39;
        boolean z39 = z38 & (functionAddress39 != 0);
        long functionAddress40 = GLContext.getFunctionAddress("glGetPathMetricRangeNV");
        this.glGetPathMetricRangeNV = functionAddress40;
        boolean z40 = z39 & (functionAddress40 != 0);
        long functionAddress41 = GLContext.getFunctionAddress("glGetPathSpacingNV");
        this.glGetPathSpacingNV = functionAddress41;
        boolean z41 = z40 & (functionAddress41 != 0);
        long functionAddress42 = GLContext.getFunctionAddress("glGetPathColorGenivNV");
        this.glGetPathColorGenivNV = functionAddress42;
        boolean z42 = z41 & (functionAddress42 != 0);
        long functionAddress43 = GLContext.getFunctionAddress("glGetPathColorGenfvNV");
        this.glGetPathColorGenfvNV = functionAddress43;
        boolean z43 = z42 & (functionAddress43 != 0);
        long functionAddress44 = GLContext.getFunctionAddress("glGetPathTexGenivNV");
        this.glGetPathTexGenivNV = functionAddress44;
        boolean z44 = z43 & (functionAddress44 != 0);
        long functionAddress45 = GLContext.getFunctionAddress("glGetPathTexGenfvNV");
        this.glGetPathTexGenfvNV = functionAddress45;
        boolean z45 = z44 & (functionAddress45 != 0);
        long functionAddress46 = GLContext.getFunctionAddress("glIsPointInFillPathNV");
        this.glIsPointInFillPathNV = functionAddress46;
        boolean z46 = z45 & (functionAddress46 != 0);
        long functionAddress47 = GLContext.getFunctionAddress("glIsPointInStrokePathNV");
        this.glIsPointInStrokePathNV = functionAddress47;
        boolean z47 = z46 & (functionAddress47 != 0);
        long functionAddress48 = GLContext.getFunctionAddress("glGetPathLengthNV");
        this.glGetPathLengthNV = functionAddress48;
        boolean z48 = z47 & (functionAddress48 != 0);
        long functionAddress49 = GLContext.getFunctionAddress("glPointAlongPathNV");
        this.glPointAlongPathNV = functionAddress49;
        return z48 & (functionAddress49 != 0);
    }

    private boolean NV_pixel_data_range_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPixelDataRangeNV");
        this.glPixelDataRangeNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFlushPixelDataRangeNV");
        this.glFlushPixelDataRangeNV = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean NV_point_sprite_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPointParameteriNV");
        this.glPointParameteriNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glPointParameterivNV");
        this.glPointParameterivNV = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean NV_present_video_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPresentFrameKeyedNV");
        this.glPresentFrameKeyedNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glPresentFrameDualFillNV");
        this.glPresentFrameDualFillNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetVideoivNV");
        this.glGetVideoivNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetVideouivNV");
        this.glGetVideouivNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetVideoi64vNV");
        this.glGetVideoi64vNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetVideoui64vNV");
        this.glGetVideoui64vNV = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean NV_primitive_restart_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glPrimitiveRestartNV");
        this.glPrimitiveRestartNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glPrimitiveRestartIndexNV");
        this.glPrimitiveRestartIndexNV = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean NV_program_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glLoadProgramNV");
        this.glLoadProgramNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindProgramNV");
        this.glBindProgramNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glDeleteProgramsNV");
        this.glDeleteProgramsNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGenProgramsNV");
        this.glGenProgramsNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetProgramivNV");
        this.glGetProgramivNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetProgramStringNV");
        this.glGetProgramStringNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glIsProgramNV");
        this.glIsProgramNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glAreProgramsResidentNV");
        this.glAreProgramsResidentNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glRequestResidentProgramsNV");
        this.glRequestResidentProgramsNV = functionAddress9;
        return z8 & (functionAddress9 != 0);
    }

    private boolean NV_register_combiners_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCombinerParameterfNV");
        this.glCombinerParameterfNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glCombinerParameterfvNV");
        this.glCombinerParameterfvNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glCombinerParameteriNV");
        this.glCombinerParameteriNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glCombinerParameterivNV");
        this.glCombinerParameterivNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glCombinerInputNV");
        this.glCombinerInputNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glCombinerOutputNV");
        this.glCombinerOutputNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glFinalCombinerInputNV");
        this.glFinalCombinerInputNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetCombinerInputParameterfvNV");
        this.glGetCombinerInputParameterfvNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetCombinerInputParameterivNV");
        this.glGetCombinerInputParameterivNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glGetCombinerOutputParameterfvNV");
        this.glGetCombinerOutputParameterfvNV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetCombinerOutputParameterivNV");
        this.glGetCombinerOutputParameterivNV = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glGetFinalCombinerInputParameterfvNV");
        this.glGetFinalCombinerInputParameterfvNV = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glGetFinalCombinerInputParameterivNV");
        this.glGetFinalCombinerInputParameterivNV = functionAddress13;
        return z12 & (functionAddress13 != 0);
    }

    private boolean NV_register_combiners2_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glCombinerStageParameterfvNV");
        this.glCombinerStageParameterfvNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetCombinerStageParameterfvNV");
        this.glGetCombinerStageParameterfvNV = functionAddress2;
        return z & (functionAddress2 != 0);
    }

    private boolean NV_shader_buffer_load_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glMakeBufferResidentNV");
        this.glMakeBufferResidentNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glMakeBufferNonResidentNV");
        this.glMakeBufferNonResidentNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glIsBufferResidentNV");
        this.glIsBufferResidentNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glMakeNamedBufferResidentNV");
        this.glMakeNamedBufferResidentNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glMakeNamedBufferNonResidentNV");
        this.glMakeNamedBufferNonResidentNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glIsNamedBufferResidentNV");
        this.glIsNamedBufferResidentNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetBufferParameterui64vNV");
        this.glGetBufferParameterui64vNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetNamedBufferParameterui64vNV");
        this.glGetNamedBufferParameterui64vNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetIntegerui64vNV");
        this.glGetIntegerui64vNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glUniformui64NV");
        this.glUniformui64NV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glUniformui64vNV");
        this.glUniformui64vNV = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glGetUniformui64vNV");
        this.glGetUniformui64vNV = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glProgramUniformui64NV");
        this.glProgramUniformui64NV = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glProgramUniformui64vNV");
        this.glProgramUniformui64vNV = functionAddress14;
        return z13 & (functionAddress14 != 0);
    }

    private boolean NV_texture_barrier_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTextureBarrierNV");
        this.glTextureBarrierNV = functionAddress;
        return functionAddress != 0;
    }

    private boolean NV_texture_multisample_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glTexImage2DMultisampleCoverageNV");
        this.glTexImage2DMultisampleCoverageNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glTexImage3DMultisampleCoverageNV");
        this.glTexImage3DMultisampleCoverageNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glTextureImage2DMultisampleNV");
        this.glTextureImage2DMultisampleNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glTextureImage3DMultisampleNV");
        this.glTextureImage3DMultisampleNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glTextureImage2DMultisampleCoverageNV");
        this.glTextureImage2DMultisampleCoverageNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glTextureImage3DMultisampleCoverageNV");
        this.glTextureImage3DMultisampleCoverageNV = functionAddress6;
        return z5 & (functionAddress6 != 0);
    }

    private boolean NV_transform_feedback_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindBufferRangeNV");
        this.glBindBufferRangeNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindBufferOffsetNV");
        this.glBindBufferOffsetNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glBindBufferBaseNV");
        this.glBindBufferBaseNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glTransformFeedbackAttribsNV");
        this.glTransformFeedbackAttribsNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glTransformFeedbackVaryingsNV");
        this.glTransformFeedbackVaryingsNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glBeginTransformFeedbackNV");
        this.glBeginTransformFeedbackNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glEndTransformFeedbackNV");
        this.glEndTransformFeedbackNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetVaryingLocationNV");
        this.glGetVaryingLocationNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glGetActiveVaryingNV");
        this.glGetActiveVaryingNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glActiveVaryingNV");
        this.glActiveVaryingNV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glGetTransformFeedbackVaryingNV");
        this.glGetTransformFeedbackVaryingNV = functionAddress11;
        return z10 & (functionAddress11 != 0);
    }

    private boolean NV_transform_feedback2_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBindTransformFeedbackNV");
        this.glBindTransformFeedbackNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glDeleteTransformFeedbacksNV");
        this.glDeleteTransformFeedbacksNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGenTransformFeedbacksNV");
        this.glGenTransformFeedbacksNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glIsTransformFeedbackNV");
        this.glIsTransformFeedbackNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glPauseTransformFeedbackNV");
        this.glPauseTransformFeedbackNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glResumeTransformFeedbackNV");
        this.glResumeTransformFeedbackNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glDrawTransformFeedbackNV");
        this.glDrawTransformFeedbackNV = functionAddress7;
        return z6 & (functionAddress7 != 0);
    }

    private boolean NV_vertex_array_range_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glVertexArrayRangeNV");
        this.glVertexArrayRangeNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glFlushVertexArrayRangeNV");
        this.glFlushVertexArrayRangeNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long platformSpecificFunctionAddress = GLContext.getPlatformSpecificFunctionAddress("gl", new String[]{"Windows", "Linux"}, new String[]{"wgl", "glX"}, "glAllocateMemoryNV");
        this.glAllocateMemoryNV = platformSpecificFunctionAddress;
        boolean z3 = z2 & (platformSpecificFunctionAddress != 0);
        long platformSpecificFunctionAddress2 = GLContext.getPlatformSpecificFunctionAddress("gl", new String[]{"Windows", "Linux"}, new String[]{"wgl", "glX"}, "glFreeMemoryNV");
        this.glFreeMemoryNV = platformSpecificFunctionAddress2;
        return z3 & (platformSpecificFunctionAddress2 != 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean NV_vertex_attrib_integer_64bit_initNativeFunctionAddresses(java.util.Set<java.lang.String> r8) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.ContextCapabilities.NV_vertex_attrib_integer_64bit_initNativeFunctionAddresses(java.util.Set):boolean");
    }

    private boolean NV_vertex_buffer_unified_memory_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBufferAddressRangeNV");
        this.glBufferAddressRangeNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glVertexFormatNV");
        this.glVertexFormatNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glNormalFormatNV");
        this.glNormalFormatNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glColorFormatNV");
        this.glColorFormatNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glIndexFormatNV");
        this.glIndexFormatNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glTexCoordFormatNV");
        this.glTexCoordFormatNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glEdgeFlagFormatNV");
        this.glEdgeFlagFormatNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glSecondaryColorFormatNV");
        this.glSecondaryColorFormatNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glFogCoordFormatNV");
        this.glFogCoordFormatNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVertexAttribFormatNV");
        this.glVertexAttribFormatNV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glVertexAttribIFormatNV");
        this.glVertexAttribIFormatNV = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glGetIntegerui64i_vNV");
        this.glGetIntegerui64i_vNV = functionAddress12;
        return z11 & (functionAddress12 != 0);
    }

    private boolean NV_vertex_program_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glExecuteProgramNV");
        this.glExecuteProgramNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glGetProgramParameterfvNV");
        this.glGetProgramParameterfvNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glGetProgramParameterdvNV");
        this.glGetProgramParameterdvNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glGetTrackMatrixivNV");
        this.glGetTrackMatrixivNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetVertexAttribfvNV");
        this.glGetVertexAttribfvNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetVertexAttribdvNV");
        this.glGetVertexAttribdvNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetVertexAttribivNV");
        this.glGetVertexAttribivNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetVertexAttribPointervNV");
        this.glGetVertexAttribPointervNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glProgramParameter4fNV");
        this.glProgramParameter4fNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glProgramParameter4dNV");
        this.glProgramParameter4dNV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glProgramParameters4fvNV");
        this.glProgramParameters4fvNV = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glProgramParameters4dvNV");
        this.glProgramParameters4dvNV = functionAddress12;
        boolean z12 = z11 & (functionAddress12 != 0);
        long functionAddress13 = GLContext.getFunctionAddress("glTrackMatrixNV");
        this.glTrackMatrixNV = functionAddress13;
        boolean z13 = z12 & (functionAddress13 != 0);
        long functionAddress14 = GLContext.getFunctionAddress("glVertexAttribPointerNV");
        this.glVertexAttribPointerNV = functionAddress14;
        boolean z14 = z13 & (functionAddress14 != 0);
        long functionAddress15 = GLContext.getFunctionAddress("glVertexAttrib1sNV");
        this.glVertexAttrib1sNV = functionAddress15;
        boolean z15 = z14 & (functionAddress15 != 0);
        long functionAddress16 = GLContext.getFunctionAddress("glVertexAttrib1fNV");
        this.glVertexAttrib1fNV = functionAddress16;
        boolean z16 = z15 & (functionAddress16 != 0);
        long functionAddress17 = GLContext.getFunctionAddress("glVertexAttrib1dNV");
        this.glVertexAttrib1dNV = functionAddress17;
        boolean z17 = z16 & (functionAddress17 != 0);
        long functionAddress18 = GLContext.getFunctionAddress("glVertexAttrib2sNV");
        this.glVertexAttrib2sNV = functionAddress18;
        boolean z18 = z17 & (functionAddress18 != 0);
        long functionAddress19 = GLContext.getFunctionAddress("glVertexAttrib2fNV");
        this.glVertexAttrib2fNV = functionAddress19;
        boolean z19 = z18 & (functionAddress19 != 0);
        long functionAddress20 = GLContext.getFunctionAddress("glVertexAttrib2dNV");
        this.glVertexAttrib2dNV = functionAddress20;
        boolean z20 = z19 & (functionAddress20 != 0);
        long functionAddress21 = GLContext.getFunctionAddress("glVertexAttrib3sNV");
        this.glVertexAttrib3sNV = functionAddress21;
        boolean z21 = z20 & (functionAddress21 != 0);
        long functionAddress22 = GLContext.getFunctionAddress("glVertexAttrib3fNV");
        this.glVertexAttrib3fNV = functionAddress22;
        boolean z22 = z21 & (functionAddress22 != 0);
        long functionAddress23 = GLContext.getFunctionAddress("glVertexAttrib3dNV");
        this.glVertexAttrib3dNV = functionAddress23;
        boolean z23 = z22 & (functionAddress23 != 0);
        long functionAddress24 = GLContext.getFunctionAddress("glVertexAttrib4sNV");
        this.glVertexAttrib4sNV = functionAddress24;
        boolean z24 = z23 & (functionAddress24 != 0);
        long functionAddress25 = GLContext.getFunctionAddress("glVertexAttrib4fNV");
        this.glVertexAttrib4fNV = functionAddress25;
        boolean z25 = z24 & (functionAddress25 != 0);
        long functionAddress26 = GLContext.getFunctionAddress("glVertexAttrib4dNV");
        this.glVertexAttrib4dNV = functionAddress26;
        boolean z26 = z25 & (functionAddress26 != 0);
        long functionAddress27 = GLContext.getFunctionAddress("glVertexAttrib4ubNV");
        this.glVertexAttrib4ubNV = functionAddress27;
        boolean z27 = z26 & (functionAddress27 != 0);
        long functionAddress28 = GLContext.getFunctionAddress("glVertexAttribs1svNV");
        this.glVertexAttribs1svNV = functionAddress28;
        boolean z28 = z27 & (functionAddress28 != 0);
        long functionAddress29 = GLContext.getFunctionAddress("glVertexAttribs1fvNV");
        this.glVertexAttribs1fvNV = functionAddress29;
        boolean z29 = z28 & (functionAddress29 != 0);
        long functionAddress30 = GLContext.getFunctionAddress("glVertexAttribs1dvNV");
        this.glVertexAttribs1dvNV = functionAddress30;
        boolean z30 = z29 & (functionAddress30 != 0);
        long functionAddress31 = GLContext.getFunctionAddress("glVertexAttribs2svNV");
        this.glVertexAttribs2svNV = functionAddress31;
        boolean z31 = z30 & (functionAddress31 != 0);
        long functionAddress32 = GLContext.getFunctionAddress("glVertexAttribs2fvNV");
        this.glVertexAttribs2fvNV = functionAddress32;
        boolean z32 = z31 & (functionAddress32 != 0);
        long functionAddress33 = GLContext.getFunctionAddress("glVertexAttribs2dvNV");
        this.glVertexAttribs2dvNV = functionAddress33;
        boolean z33 = z32 & (functionAddress33 != 0);
        long functionAddress34 = GLContext.getFunctionAddress("glVertexAttribs3svNV");
        this.glVertexAttribs3svNV = functionAddress34;
        boolean z34 = z33 & (functionAddress34 != 0);
        long functionAddress35 = GLContext.getFunctionAddress("glVertexAttribs3fvNV");
        this.glVertexAttribs3fvNV = functionAddress35;
        boolean z35 = z34 & (functionAddress35 != 0);
        long functionAddress36 = GLContext.getFunctionAddress("glVertexAttribs3dvNV");
        this.glVertexAttribs3dvNV = functionAddress36;
        boolean z36 = z35 & (functionAddress36 != 0);
        long functionAddress37 = GLContext.getFunctionAddress("glVertexAttribs4svNV");
        this.glVertexAttribs4svNV = functionAddress37;
        boolean z37 = z36 & (functionAddress37 != 0);
        long functionAddress38 = GLContext.getFunctionAddress("glVertexAttribs4fvNV");
        this.glVertexAttribs4fvNV = functionAddress38;
        boolean z38 = z37 & (functionAddress38 != 0);
        long functionAddress39 = GLContext.getFunctionAddress("glVertexAttribs4dvNV");
        this.glVertexAttribs4dvNV = functionAddress39;
        return z38 & (functionAddress39 != 0);
    }

    private boolean NV_video_capture_initNativeFunctionAddresses() {
        long functionAddress = GLContext.getFunctionAddress("glBeginVideoCaptureNV");
        this.glBeginVideoCaptureNV = functionAddress;
        boolean z = functionAddress != 0;
        long functionAddress2 = GLContext.getFunctionAddress("glBindVideoCaptureStreamBufferNV");
        this.glBindVideoCaptureStreamBufferNV = functionAddress2;
        boolean z2 = z & (functionAddress2 != 0);
        long functionAddress3 = GLContext.getFunctionAddress("glBindVideoCaptureStreamTextureNV");
        this.glBindVideoCaptureStreamTextureNV = functionAddress3;
        boolean z3 = z2 & (functionAddress3 != 0);
        long functionAddress4 = GLContext.getFunctionAddress("glEndVideoCaptureNV");
        this.glEndVideoCaptureNV = functionAddress4;
        boolean z4 = z3 & (functionAddress4 != 0);
        long functionAddress5 = GLContext.getFunctionAddress("glGetVideoCaptureivNV");
        this.glGetVideoCaptureivNV = functionAddress5;
        boolean z5 = z4 & (functionAddress5 != 0);
        long functionAddress6 = GLContext.getFunctionAddress("glGetVideoCaptureStreamivNV");
        this.glGetVideoCaptureStreamivNV = functionAddress6;
        boolean z6 = z5 & (functionAddress6 != 0);
        long functionAddress7 = GLContext.getFunctionAddress("glGetVideoCaptureStreamfvNV");
        this.glGetVideoCaptureStreamfvNV = functionAddress7;
        boolean z7 = z6 & (functionAddress7 != 0);
        long functionAddress8 = GLContext.getFunctionAddress("glGetVideoCaptureStreamdvNV");
        this.glGetVideoCaptureStreamdvNV = functionAddress8;
        boolean z8 = z7 & (functionAddress8 != 0);
        long functionAddress9 = GLContext.getFunctionAddress("glVideoCaptureNV");
        this.glVideoCaptureNV = functionAddress9;
        boolean z9 = z8 & (functionAddress9 != 0);
        long functionAddress10 = GLContext.getFunctionAddress("glVideoCaptureStreamParameterivNV");
        this.glVideoCaptureStreamParameterivNV = functionAddress10;
        boolean z10 = z9 & (functionAddress10 != 0);
        long functionAddress11 = GLContext.getFunctionAddress("glVideoCaptureStreamParameterfvNV");
        this.glVideoCaptureStreamParameterfvNV = functionAddress11;
        boolean z11 = z10 & (functionAddress11 != 0);
        long functionAddress12 = GLContext.getFunctionAddress("glVideoCaptureStreamParameterdvNV");
        this.glVideoCaptureStreamParameterdvNV = functionAddress12;
        return z11 & (functionAddress12 != 0);
    }

    private static void remove(Set supported_extensions, String extension) {
        LWJGLUtil.log(extension + " was reported as available but an entry point is missing");
        supported_extensions.remove(extension);
    }

    private Set<String> initAllStubs(boolean forwardCompatible) throws LWJGLException {
        this.glGetError = GLContext.getFunctionAddress("glGetError");
        this.glGetString = GLContext.getFunctionAddress("glGetString");
        this.glGetIntegerv = GLContext.getFunctionAddress("glGetIntegerv");
        this.glGetStringi = GLContext.getFunctionAddress("glGetStringi");
        GLContext.setCapabilities(this);
        Set<String> supported_extensions = new HashSet<>(256);
        int profileMask = GLContext.getSupportedExtensions(supported_extensions);
        if (supported_extensions.contains("OpenGL31") && !supported_extensions.contains("GL_ARB_compatibility") && (profileMask & 2) == 0) {
            forwardCompatible = true;
        }
        if (!GL11_initNativeFunctionAddresses(forwardCompatible)) {
            throw new LWJGLException("GL11 not supported");
        }
        if (supported_extensions.contains("GL_ARB_fragment_program")) {
            supported_extensions.add("GL_ARB_program");
        }
        if (supported_extensions.contains("GL_ARB_pixel_buffer_object")) {
            supported_extensions.add("GL_ARB_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_vertex_buffer_object")) {
            supported_extensions.add("GL_ARB_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_vertex_program")) {
            supported_extensions.add("GL_ARB_program");
        }
        if (supported_extensions.contains("GL_EXT_pixel_buffer_object")) {
            supported_extensions.add("GL_ARB_buffer_object");
        }
        if (supported_extensions.contains("GL_NV_fragment_program")) {
            supported_extensions.add("GL_NV_program");
        }
        if (supported_extensions.contains("GL_NV_vertex_program")) {
            supported_extensions.add("GL_NV_program");
        }
        if ((supported_extensions.contains("GL_AMD_debug_output") || supported_extensions.contains("GL_AMDX_debug_output")) && !AMD_debug_output_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMDX_debug_output");
            remove(supported_extensions, "GL_AMD_debug_output");
        }
        if (supported_extensions.contains("GL_AMD_draw_buffers_blend") && !AMD_draw_buffers_blend_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_draw_buffers_blend");
        }
        if (supported_extensions.contains("GL_AMD_interleaved_elements") && !AMD_interleaved_elements_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_interleaved_elements");
        }
        if (supported_extensions.contains("GL_AMD_multi_draw_indirect") && !AMD_multi_draw_indirect_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_multi_draw_indirect");
        }
        if (supported_extensions.contains("GL_AMD_name_gen_delete") && !AMD_name_gen_delete_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_name_gen_delete");
        }
        if (supported_extensions.contains("GL_AMD_performance_monitor") && !AMD_performance_monitor_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_performance_monitor");
        }
        if (supported_extensions.contains("GL_AMD_sample_positions") && !AMD_sample_positions_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_sample_positions");
        }
        if (supported_extensions.contains("GL_AMD_sparse_texture") && !AMD_sparse_texture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_sparse_texture");
        }
        if (supported_extensions.contains("GL_AMD_stencil_operation_extended") && !AMD_stencil_operation_extended_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_stencil_operation_extended");
        }
        if (supported_extensions.contains("GL_AMD_vertex_shader_tessellator") && !AMD_vertex_shader_tessellator_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_AMD_vertex_shader_tessellator");
        }
        if (supported_extensions.contains("GL_APPLE_element_array") && !APPLE_element_array_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_APPLE_element_array");
        }
        if (supported_extensions.contains("GL_APPLE_fence") && !APPLE_fence_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_APPLE_fence");
        }
        if (supported_extensions.contains("GL_APPLE_flush_buffer_range") && !APPLE_flush_buffer_range_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_APPLE_flush_buffer_range");
        }
        if (supported_extensions.contains("GL_APPLE_object_purgeable") && !APPLE_object_purgeable_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_APPLE_object_purgeable");
        }
        if (supported_extensions.contains("GL_APPLE_texture_range") && !APPLE_texture_range_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_APPLE_texture_range");
        }
        if (supported_extensions.contains("GL_APPLE_vertex_array_object") && !APPLE_vertex_array_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_APPLE_vertex_array_object");
        }
        if (supported_extensions.contains("GL_APPLE_vertex_array_range") && !APPLE_vertex_array_range_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_APPLE_vertex_array_range");
        }
        if (supported_extensions.contains("GL_APPLE_vertex_program_evaluators") && !APPLE_vertex_program_evaluators_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_APPLE_vertex_program_evaluators");
        }
        if (supported_extensions.contains("GL_ARB_ES2_compatibility") && !ARB_ES2_compatibility_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_ES2_compatibility");
        }
        if (supported_extensions.contains("GL_ARB_ES3_1_compatibility") && !ARB_ES3_1_compatibility_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_ES3_1_compatibility");
        }
        if (supported_extensions.contains("GL_ARB_base_instance") && !ARB_base_instance_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_base_instance");
        }
        if (supported_extensions.contains("GL_ARB_bindless_texture") && !ARB_bindless_texture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_bindless_texture");
        }
        if (supported_extensions.contains("GL_ARB_blend_func_extended") && !ARB_blend_func_extended_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_blend_func_extended");
        }
        if (supported_extensions.contains("GL_ARB_buffer_object") && !ARB_buffer_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_buffer_storage") && !ARB_buffer_storage_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_ARB_buffer_storage");
        }
        if (supported_extensions.contains("GL_ARB_cl_event") && !ARB_cl_event_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_cl_event");
        }
        if (supported_extensions.contains("GL_ARB_clear_buffer_object") && !ARB_clear_buffer_object_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_ARB_clear_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_clear_texture") && !ARB_clear_texture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_clear_texture");
        }
        if (supported_extensions.contains("GL_ARB_clip_control") && !ARB_clip_control_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_clip_control");
        }
        if (supported_extensions.contains("GL_ARB_color_buffer_float") && !ARB_color_buffer_float_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_color_buffer_float");
        }
        if (supported_extensions.contains("GL_ARB_compute_shader") && !ARB_compute_shader_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_compute_shader");
        }
        if (supported_extensions.contains("GL_ARB_compute_variable_group_size") && !ARB_compute_variable_group_size_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_compute_variable_group_size");
        }
        if (supported_extensions.contains("GL_ARB_copy_buffer") && !ARB_copy_buffer_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_copy_buffer");
        }
        if (supported_extensions.contains("GL_ARB_copy_image") && !ARB_copy_image_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_copy_image");
        }
        if (supported_extensions.contains("GL_ARB_debug_output") && !ARB_debug_output_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_debug_output");
        }
        if (supported_extensions.contains("GL_ARB_direct_state_access") && !ARB_direct_state_access_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_direct_state_access");
        }
        if (supported_extensions.contains("GL_ARB_draw_buffers") && !ARB_draw_buffers_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_draw_buffers");
        }
        if (supported_extensions.contains("GL_ARB_draw_buffers_blend") && !ARB_draw_buffers_blend_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_draw_buffers_blend");
        }
        if (supported_extensions.contains("GL_ARB_draw_elements_base_vertex") && !ARB_draw_elements_base_vertex_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_draw_elements_base_vertex");
        }
        if (supported_extensions.contains("GL_ARB_draw_indirect") && !ARB_draw_indirect_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_draw_indirect");
        }
        if (supported_extensions.contains("GL_ARB_draw_instanced") && !ARB_draw_instanced_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_draw_instanced");
        }
        if (supported_extensions.contains("GL_ARB_framebuffer_no_attachments") && !ARB_framebuffer_no_attachments_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_ARB_framebuffer_no_attachments");
        }
        if (supported_extensions.contains("GL_ARB_framebuffer_object") && !ARB_framebuffer_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_framebuffer_object");
        }
        if (supported_extensions.contains("GL_ARB_geometry_shader4") && !ARB_geometry_shader4_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_geometry_shader4");
        }
        if (supported_extensions.contains("GL_ARB_get_program_binary") && !ARB_get_program_binary_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_get_program_binary");
        }
        if (supported_extensions.contains("GL_ARB_get_texture_sub_image") && !ARB_get_texture_sub_image_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_get_texture_sub_image");
        }
        if (supported_extensions.contains("GL_ARB_gpu_shader_fp64") && !ARB_gpu_shader_fp64_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_ARB_gpu_shader_fp64");
        }
        if (supported_extensions.contains("GL_ARB_imaging") && !ARB_imaging_initNativeFunctionAddresses(forwardCompatible)) {
            remove(supported_extensions, "GL_ARB_imaging");
        }
        if (supported_extensions.contains("GL_ARB_indirect_parameters") && !ARB_indirect_parameters_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_indirect_parameters");
        }
        if (supported_extensions.contains("GL_ARB_instanced_arrays") && !ARB_instanced_arrays_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_instanced_arrays");
        }
        if (supported_extensions.contains("GL_ARB_internalformat_query") && !ARB_internalformat_query_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_internalformat_query");
        }
        if (supported_extensions.contains("GL_ARB_internalformat_query2") && !ARB_internalformat_query2_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_internalformat_query2");
        }
        if (supported_extensions.contains("GL_ARB_invalidate_subdata") && !ARB_invalidate_subdata_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_invalidate_subdata");
        }
        if (supported_extensions.contains("GL_ARB_map_buffer_range") && !ARB_map_buffer_range_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_map_buffer_range");
        }
        if (supported_extensions.contains("GL_ARB_matrix_palette") && !ARB_matrix_palette_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_matrix_palette");
        }
        if (supported_extensions.contains("GL_ARB_multi_bind") && !ARB_multi_bind_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_multi_bind");
        }
        if (supported_extensions.contains("GL_ARB_multi_draw_indirect") && !ARB_multi_draw_indirect_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_multi_draw_indirect");
        }
        if (supported_extensions.contains("GL_ARB_multisample") && !ARB_multisample_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_multisample");
        }
        if (supported_extensions.contains("GL_ARB_multitexture") && !ARB_multitexture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_multitexture");
        }
        if (supported_extensions.contains("GL_ARB_occlusion_query") && !ARB_occlusion_query_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_occlusion_query");
        }
        if (supported_extensions.contains("GL_ARB_point_parameters") && !ARB_point_parameters_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_point_parameters");
        }
        if (supported_extensions.contains("GL_ARB_program") && !ARB_program_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_program");
        }
        if (supported_extensions.contains("GL_ARB_program_interface_query") && !ARB_program_interface_query_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_program_interface_query");
        }
        if (supported_extensions.contains("GL_ARB_provoking_vertex") && !ARB_provoking_vertex_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_provoking_vertex");
        }
        if (supported_extensions.contains("GL_ARB_robustness") && !ARB_robustness_initNativeFunctionAddresses(forwardCompatible, supported_extensions)) {
            remove(supported_extensions, "GL_ARB_robustness");
        }
        if (supported_extensions.contains("GL_ARB_sample_shading") && !ARB_sample_shading_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_sample_shading");
        }
        if (supported_extensions.contains("GL_ARB_sampler_objects") && !ARB_sampler_objects_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_sampler_objects");
        }
        if (supported_extensions.contains("GL_ARB_separate_shader_objects") && !ARB_separate_shader_objects_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_separate_shader_objects");
        }
        if (supported_extensions.contains("GL_ARB_shader_atomic_counters") && !ARB_shader_atomic_counters_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_shader_atomic_counters");
        }
        if (supported_extensions.contains("GL_ARB_shader_image_load_store") && !ARB_shader_image_load_store_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_shader_image_load_store");
        }
        if (supported_extensions.contains("GL_ARB_shader_objects") && !ARB_shader_objects_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_shader_objects");
        }
        if (supported_extensions.contains("GL_ARB_shader_storage_buffer_object") && !ARB_shader_storage_buffer_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_shader_storage_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_shader_subroutine") && !ARB_shader_subroutine_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_shader_subroutine");
        }
        if (supported_extensions.contains("GL_ARB_shading_language_include") && !ARB_shading_language_include_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_shading_language_include");
        }
        if (supported_extensions.contains("GL_ARB_sparse_buffer") && !ARB_sparse_buffer_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_sparse_buffer");
        }
        if (supported_extensions.contains("GL_ARB_sparse_texture") && !ARB_sparse_texture_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_ARB_sparse_texture");
        }
        if (supported_extensions.contains("GL_ARB_sync") && !ARB_sync_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_sync");
        }
        if (supported_extensions.contains("GL_ARB_tessellation_shader") && !ARB_tessellation_shader_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_tessellation_shader");
        }
        if (supported_extensions.contains("GL_ARB_texture_barrier") && !ARB_texture_barrier_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_texture_barrier");
        }
        if (supported_extensions.contains("GL_ARB_texture_buffer_object") && !ARB_texture_buffer_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_texture_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_texture_buffer_range") && !ARB_texture_buffer_range_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_ARB_texture_buffer_range");
        }
        if (supported_extensions.contains("GL_ARB_texture_compression") && !ARB_texture_compression_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_texture_compression");
        }
        if (supported_extensions.contains("GL_ARB_texture_multisample") && !ARB_texture_multisample_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_texture_multisample");
        }
        if ((supported_extensions.contains("GL_ARB_texture_storage") || supported_extensions.contains("GL_EXT_texture_storage")) && !ARB_texture_storage_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_EXT_texture_storage");
            remove(supported_extensions, "GL_ARB_texture_storage");
        }
        if (supported_extensions.contains("GL_ARB_texture_storage_multisample") && !ARB_texture_storage_multisample_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_ARB_texture_storage_multisample");
        }
        if (supported_extensions.contains("GL_ARB_texture_view") && !ARB_texture_view_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_texture_view");
        }
        if (supported_extensions.contains("GL_ARB_timer_query") && !ARB_timer_query_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_timer_query");
        }
        if (supported_extensions.contains("GL_ARB_transform_feedback2") && !ARB_transform_feedback2_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_transform_feedback2");
        }
        if (supported_extensions.contains("GL_ARB_transform_feedback3") && !ARB_transform_feedback3_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_transform_feedback3");
        }
        if (supported_extensions.contains("GL_ARB_transform_feedback_instanced") && !ARB_transform_feedback_instanced_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_transform_feedback_instanced");
        }
        if (supported_extensions.contains("GL_ARB_transpose_matrix") && !ARB_transpose_matrix_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_transpose_matrix");
        }
        if (supported_extensions.contains("GL_ARB_uniform_buffer_object") && !ARB_uniform_buffer_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_uniform_buffer_object");
        }
        if (supported_extensions.contains("GL_ARB_vertex_array_object") && !ARB_vertex_array_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_vertex_array_object");
        }
        if (supported_extensions.contains("GL_ARB_vertex_attrib_64bit") && !ARB_vertex_attrib_64bit_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_ARB_vertex_attrib_64bit");
        }
        if (supported_extensions.contains("GL_ARB_vertex_attrib_binding") && !ARB_vertex_attrib_binding_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_vertex_attrib_binding");
        }
        if (supported_extensions.contains("GL_ARB_vertex_blend") && !ARB_vertex_blend_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_vertex_blend");
        }
        if (supported_extensions.contains("GL_ARB_vertex_program") && !ARB_vertex_program_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_vertex_program");
        }
        if (supported_extensions.contains("GL_ARB_vertex_shader") && !ARB_vertex_shader_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_vertex_shader");
        }
        if (supported_extensions.contains("GL_ARB_vertex_type_2_10_10_10_rev") && !ARB_vertex_type_2_10_10_10_rev_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_vertex_type_2_10_10_10_rev");
        }
        if (supported_extensions.contains("GL_ARB_viewport_array") && !ARB_viewport_array_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ARB_viewport_array");
        }
        if (supported_extensions.contains("GL_ARB_window_pos") && !ARB_window_pos_initNativeFunctionAddresses(forwardCompatible)) {
            remove(supported_extensions, "GL_ARB_window_pos");
        }
        if (supported_extensions.contains("GL_ATI_draw_buffers") && !ATI_draw_buffers_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_draw_buffers");
        }
        if (supported_extensions.contains("GL_ATI_element_array") && !ATI_element_array_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_element_array");
        }
        if (supported_extensions.contains("GL_ATI_envmap_bumpmap") && !ATI_envmap_bumpmap_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_envmap_bumpmap");
        }
        if (supported_extensions.contains("GL_ATI_fragment_shader") && !ATI_fragment_shader_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_fragment_shader");
        }
        if (supported_extensions.contains("GL_ATI_map_object_buffer") && !ATI_map_object_buffer_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_map_object_buffer");
        }
        if (supported_extensions.contains("GL_ATI_pn_triangles") && !ATI_pn_triangles_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_pn_triangles");
        }
        if (supported_extensions.contains("GL_ATI_separate_stencil") && !ATI_separate_stencil_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_separate_stencil");
        }
        if (supported_extensions.contains("GL_ATI_vertex_array_object") && !ATI_vertex_array_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_vertex_array_object");
        }
        if (supported_extensions.contains("GL_ATI_vertex_attrib_array_object") && !ATI_vertex_attrib_array_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_vertex_attrib_array_object");
        }
        if (supported_extensions.contains("GL_ATI_vertex_streams") && !ATI_vertex_streams_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_ATI_vertex_streams");
        }
        if (supported_extensions.contains("GL_EXT_bindable_uniform") && !EXT_bindable_uniform_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_bindable_uniform");
        }
        if (supported_extensions.contains("GL_EXT_blend_color") && !EXT_blend_color_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_blend_color");
        }
        if (supported_extensions.contains("GL_EXT_blend_equation_separate") && !EXT_blend_equation_separate_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_blend_equation_separate");
        }
        if (supported_extensions.contains("GL_EXT_blend_func_separate") && !EXT_blend_func_separate_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_blend_func_separate");
        }
        if (supported_extensions.contains("GL_EXT_blend_minmax") && !EXT_blend_minmax_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_blend_minmax");
        }
        if (supported_extensions.contains("GL_EXT_compiled_vertex_array") && !EXT_compiled_vertex_array_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_compiled_vertex_array");
        }
        if (supported_extensions.contains("GL_EXT_depth_bounds_test") && !EXT_depth_bounds_test_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_depth_bounds_test");
        }
        supported_extensions.add("GL_EXT_direct_state_access");
        if (supported_extensions.contains("GL_EXT_direct_state_access") && !EXT_direct_state_access_initNativeFunctionAddresses(forwardCompatible, supported_extensions)) {
            remove(supported_extensions, "GL_EXT_direct_state_access");
        }
        if (supported_extensions.contains("GL_EXT_draw_buffers2") && !EXT_draw_buffers2_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_draw_buffers2");
        }
        if (supported_extensions.contains("GL_EXT_draw_instanced") && !EXT_draw_instanced_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_draw_instanced");
        }
        if (supported_extensions.contains("GL_EXT_draw_range_elements") && !EXT_draw_range_elements_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_draw_range_elements");
        }
        if (supported_extensions.contains("GL_EXT_fog_coord") && !EXT_fog_coord_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_fog_coord");
        }
        if (supported_extensions.contains("GL_EXT_framebuffer_blit") && !EXT_framebuffer_blit_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_framebuffer_blit");
        }
        if (supported_extensions.contains("GL_EXT_framebuffer_multisample") && !EXT_framebuffer_multisample_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_framebuffer_multisample");
        }
        if (supported_extensions.contains("GL_EXT_framebuffer_object") && !EXT_framebuffer_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_framebuffer_object");
        }
        if (supported_extensions.contains("GL_EXT_geometry_shader4") && !EXT_geometry_shader4_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_geometry_shader4");
        }
        if (supported_extensions.contains("GL_EXT_gpu_program_parameters") && !EXT_gpu_program_parameters_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_gpu_program_parameters");
        }
        if (supported_extensions.contains("GL_EXT_gpu_shader4") && !EXT_gpu_shader4_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_gpu_shader4");
        }
        if (supported_extensions.contains("GL_EXT_multi_draw_arrays") && !EXT_multi_draw_arrays_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_multi_draw_arrays");
        }
        if (supported_extensions.contains("GL_EXT_paletted_texture") && !EXT_paletted_texture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_paletted_texture");
        }
        if (supported_extensions.contains("GL_EXT_point_parameters") && !EXT_point_parameters_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_point_parameters");
        }
        if (supported_extensions.contains("GL_EXT_provoking_vertex") && !EXT_provoking_vertex_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_provoking_vertex");
        }
        if (supported_extensions.contains("GL_EXT_secondary_color") && !EXT_secondary_color_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_secondary_color");
        }
        if (supported_extensions.contains("GL_EXT_separate_shader_objects") && !EXT_separate_shader_objects_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_separate_shader_objects");
        }
        if (supported_extensions.contains("GL_EXT_shader_image_load_store") && !EXT_shader_image_load_store_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_shader_image_load_store");
        }
        if (supported_extensions.contains("GL_EXT_stencil_clear_tag") && !EXT_stencil_clear_tag_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_stencil_clear_tag");
        }
        if (supported_extensions.contains("GL_EXT_stencil_two_side") && !EXT_stencil_two_side_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_stencil_two_side");
        }
        if (supported_extensions.contains("GL_EXT_texture_array") && !EXT_texture_array_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_texture_array");
        }
        if (supported_extensions.contains("GL_EXT_texture_buffer_object") && !EXT_texture_buffer_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_texture_buffer_object");
        }
        if (supported_extensions.contains("GL_EXT_texture_integer") && !EXT_texture_integer_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_texture_integer");
        }
        if (supported_extensions.contains("GL_EXT_timer_query") && !EXT_timer_query_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_timer_query");
        }
        if (supported_extensions.contains("GL_EXT_transform_feedback") && !EXT_transform_feedback_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_transform_feedback");
        }
        if (supported_extensions.contains("GL_EXT_vertex_attrib_64bit") && !EXT_vertex_attrib_64bit_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_EXT_vertex_attrib_64bit");
        }
        if (supported_extensions.contains("GL_EXT_vertex_shader") && !EXT_vertex_shader_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_vertex_shader");
        }
        if (supported_extensions.contains("GL_EXT_vertex_weighting") && !EXT_vertex_weighting_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_EXT_vertex_weighting");
        }
        if (supported_extensions.contains("OpenGL12") && !GL12_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL12");
        }
        if (supported_extensions.contains("OpenGL13") && !GL13_initNativeFunctionAddresses(forwardCompatible)) {
            remove(supported_extensions, "OpenGL13");
        }
        if (supported_extensions.contains("OpenGL14") && !GL14_initNativeFunctionAddresses(forwardCompatible)) {
            remove(supported_extensions, "OpenGL14");
        }
        if (supported_extensions.contains("OpenGL15") && !GL15_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL15");
        }
        if (supported_extensions.contains("OpenGL20") && !GL20_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL20");
        }
        if (supported_extensions.contains("OpenGL21") && !GL21_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL21");
        }
        if (supported_extensions.contains("OpenGL30") && !GL30_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL30");
        }
        if (supported_extensions.contains("OpenGL31") && !GL31_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL31");
        }
        if (supported_extensions.contains("OpenGL32") && !GL32_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL32");
        }
        if (supported_extensions.contains("OpenGL33") && !GL33_initNativeFunctionAddresses(forwardCompatible)) {
            remove(supported_extensions, "OpenGL33");
        }
        if (supported_extensions.contains("OpenGL40") && !GL40_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL40");
        }
        if (supported_extensions.contains("OpenGL41") && !GL41_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL41");
        }
        if (supported_extensions.contains("OpenGL42") && !GL42_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL42");
        }
        if (supported_extensions.contains("OpenGL43") && !GL43_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL43");
        }
        if (supported_extensions.contains("OpenGL44") && !GL44_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL44");
        }
        if (supported_extensions.contains("OpenGL45") && !GL45_initNativeFunctionAddresses()) {
            remove(supported_extensions, "OpenGL45");
        }
        if (supported_extensions.contains("GL_GREMEDY_frame_terminator") && !GREMEDY_frame_terminator_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_GREMEDY_frame_terminator");
        }
        if (supported_extensions.contains("GL_GREMEDY_string_marker") && !GREMEDY_string_marker_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_GREMEDY_string_marker");
        }
        if (supported_extensions.contains("GL_INTEL_map_texture") && !INTEL_map_texture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_INTEL_map_texture");
        }
        if (supported_extensions.contains("GL_KHR_debug") && !KHR_debug_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_KHR_debug");
        }
        if (supported_extensions.contains("GL_KHR_robustness") && !KHR_robustness_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_KHR_robustness");
        }
        if (supported_extensions.contains("GL_NV_bindless_multi_draw_indirect") && !NV_bindless_multi_draw_indirect_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_bindless_multi_draw_indirect");
        }
        if (supported_extensions.contains("GL_NV_bindless_texture") && !NV_bindless_texture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_bindless_texture");
        }
        if (supported_extensions.contains("GL_NV_blend_equation_advanced") && !NV_blend_equation_advanced_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_blend_equation_advanced");
        }
        if (supported_extensions.contains("GL_NV_conditional_render") && !NV_conditional_render_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_conditional_render");
        }
        if (supported_extensions.contains("GL_NV_copy_image") && !NV_copy_image_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_copy_image");
        }
        if (supported_extensions.contains("GL_NV_depth_buffer_float") && !NV_depth_buffer_float_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_depth_buffer_float");
        }
        if (supported_extensions.contains("GL_NV_draw_texture") && !NV_draw_texture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_draw_texture");
        }
        if (supported_extensions.contains("GL_NV_evaluators") && !NV_evaluators_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_evaluators");
        }
        if (supported_extensions.contains("GL_NV_explicit_multisample") && !NV_explicit_multisample_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_explicit_multisample");
        }
        if (supported_extensions.contains("GL_NV_fence") && !NV_fence_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_fence");
        }
        if (supported_extensions.contains("GL_NV_fragment_program") && !NV_fragment_program_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_fragment_program");
        }
        if (supported_extensions.contains("GL_NV_framebuffer_multisample_coverage") && !NV_framebuffer_multisample_coverage_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_framebuffer_multisample_coverage");
        }
        if (supported_extensions.contains("GL_NV_geometry_program4") && !NV_geometry_program4_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_geometry_program4");
        }
        if (supported_extensions.contains("GL_NV_gpu_program4") && !NV_gpu_program4_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_gpu_program4");
        }
        if (supported_extensions.contains("GL_NV_gpu_shader5") && !NV_gpu_shader5_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_NV_gpu_shader5");
        }
        if (supported_extensions.contains("GL_NV_half_float") && !NV_half_float_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_NV_half_float");
        }
        if (supported_extensions.contains("GL_NV_occlusion_query") && !NV_occlusion_query_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_occlusion_query");
        }
        if (supported_extensions.contains("GL_NV_parameter_buffer_object") && !NV_parameter_buffer_object_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_parameter_buffer_object");
        }
        if (supported_extensions.contains("GL_NV_path_rendering") && !NV_path_rendering_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_path_rendering");
        }
        if (supported_extensions.contains("GL_NV_pixel_data_range") && !NV_pixel_data_range_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_pixel_data_range");
        }
        if (supported_extensions.contains("GL_NV_point_sprite") && !NV_point_sprite_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_point_sprite");
        }
        if (supported_extensions.contains("GL_NV_present_video") && !NV_present_video_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_present_video");
        }
        supported_extensions.add("GL_NV_primitive_restart");
        if (supported_extensions.contains("GL_NV_primitive_restart") && !NV_primitive_restart_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_primitive_restart");
        }
        if (supported_extensions.contains("GL_NV_program") && !NV_program_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_program");
        }
        if (supported_extensions.contains("GL_NV_register_combiners") && !NV_register_combiners_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_register_combiners");
        }
        if (supported_extensions.contains("GL_NV_register_combiners2") && !NV_register_combiners2_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_register_combiners2");
        }
        if (supported_extensions.contains("GL_NV_shader_buffer_load") && !NV_shader_buffer_load_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_shader_buffer_load");
        }
        if (supported_extensions.contains("GL_NV_texture_barrier") && !NV_texture_barrier_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_texture_barrier");
        }
        if (supported_extensions.contains("GL_NV_texture_multisample") && !NV_texture_multisample_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_texture_multisample");
        }
        if (supported_extensions.contains("GL_NV_transform_feedback") && !NV_transform_feedback_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_transform_feedback");
        }
        if (supported_extensions.contains("GL_NV_transform_feedback2") && !NV_transform_feedback2_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_transform_feedback2");
        }
        if (supported_extensions.contains("GL_NV_vertex_array_range") && !NV_vertex_array_range_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_vertex_array_range");
        }
        if (supported_extensions.contains("GL_NV_vertex_attrib_integer_64bit") && !NV_vertex_attrib_integer_64bit_initNativeFunctionAddresses(supported_extensions)) {
            remove(supported_extensions, "GL_NV_vertex_attrib_integer_64bit");
        }
        if (supported_extensions.contains("GL_NV_vertex_buffer_unified_memory") && !NV_vertex_buffer_unified_memory_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_vertex_buffer_unified_memory");
        }
        if (supported_extensions.contains("GL_NV_vertex_program") && !NV_vertex_program_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_vertex_program");
        }
        if (supported_extensions.contains("GL_NV_video_capture") && !NV_video_capture_initNativeFunctionAddresses()) {
            remove(supported_extensions, "GL_NV_video_capture");
        }
        return supported_extensions;
    }

    static void unloadAllStubs() {
    }

    ContextCapabilities(boolean forwardCompatible) throws LWJGLException {
        Set<String> supported_extensions = initAllStubs(forwardCompatible);
        this.GL_AMD_blend_minmax_factor = supported_extensions.contains("GL_AMD_blend_minmax_factor");
        this.GL_AMD_conservative_depth = supported_extensions.contains("GL_AMD_conservative_depth");
        this.GL_AMD_debug_output = supported_extensions.contains("GL_AMD_debug_output") || supported_extensions.contains("GL_AMDX_debug_output");
        this.GL_AMD_depth_clamp_separate = supported_extensions.contains("GL_AMD_depth_clamp_separate");
        this.GL_AMD_draw_buffers_blend = supported_extensions.contains("GL_AMD_draw_buffers_blend");
        this.GL_AMD_interleaved_elements = supported_extensions.contains("GL_AMD_interleaved_elements");
        this.GL_AMD_multi_draw_indirect = supported_extensions.contains("GL_AMD_multi_draw_indirect");
        this.GL_AMD_name_gen_delete = supported_extensions.contains("GL_AMD_name_gen_delete");
        this.GL_AMD_performance_monitor = supported_extensions.contains("GL_AMD_performance_monitor");
        this.GL_AMD_pinned_memory = supported_extensions.contains("GL_AMD_pinned_memory");
        this.GL_AMD_query_buffer_object = supported_extensions.contains("GL_AMD_query_buffer_object");
        this.GL_AMD_sample_positions = supported_extensions.contains("GL_AMD_sample_positions");
        this.GL_AMD_seamless_cubemap_per_texture = supported_extensions.contains("GL_AMD_seamless_cubemap_per_texture");
        this.GL_AMD_shader_atomic_counter_ops = supported_extensions.contains("GL_AMD_shader_atomic_counter_ops");
        this.GL_AMD_shader_stencil_export = supported_extensions.contains("GL_AMD_shader_stencil_export");
        this.GL_AMD_shader_trinary_minmax = supported_extensions.contains("GL_AMD_shader_trinary_minmax");
        this.GL_AMD_sparse_texture = supported_extensions.contains("GL_AMD_sparse_texture");
        this.GL_AMD_stencil_operation_extended = supported_extensions.contains("GL_AMD_stencil_operation_extended");
        this.GL_AMD_texture_texture4 = supported_extensions.contains("GL_AMD_texture_texture4");
        this.GL_AMD_transform_feedback3_lines_triangles = supported_extensions.contains("GL_AMD_transform_feedback3_lines_triangles");
        this.GL_AMD_vertex_shader_layer = supported_extensions.contains("GL_AMD_vertex_shader_layer");
        this.GL_AMD_vertex_shader_tessellator = supported_extensions.contains("GL_AMD_vertex_shader_tessellator");
        this.GL_AMD_vertex_shader_viewport_index = supported_extensions.contains("GL_AMD_vertex_shader_viewport_index");
        this.GL_APPLE_aux_depth_stencil = supported_extensions.contains("GL_APPLE_aux_depth_stencil");
        this.GL_APPLE_client_storage = supported_extensions.contains("GL_APPLE_client_storage");
        this.GL_APPLE_element_array = supported_extensions.contains("GL_APPLE_element_array");
        this.GL_APPLE_fence = supported_extensions.contains("GL_APPLE_fence");
        this.GL_APPLE_float_pixels = supported_extensions.contains("GL_APPLE_float_pixels");
        this.GL_APPLE_flush_buffer_range = supported_extensions.contains("GL_APPLE_flush_buffer_range");
        this.GL_APPLE_object_purgeable = supported_extensions.contains("GL_APPLE_object_purgeable");
        this.GL_APPLE_packed_pixels = supported_extensions.contains("GL_APPLE_packed_pixels");
        this.GL_APPLE_rgb_422 = supported_extensions.contains("GL_APPLE_rgb_422");
        this.GL_APPLE_row_bytes = supported_extensions.contains("GL_APPLE_row_bytes");
        this.GL_APPLE_texture_range = supported_extensions.contains("GL_APPLE_texture_range");
        this.GL_APPLE_vertex_array_object = supported_extensions.contains("GL_APPLE_vertex_array_object");
        this.GL_APPLE_vertex_array_range = supported_extensions.contains("GL_APPLE_vertex_array_range");
        this.GL_APPLE_vertex_program_evaluators = supported_extensions.contains("GL_APPLE_vertex_program_evaluators");
        this.GL_APPLE_ycbcr_422 = supported_extensions.contains("GL_APPLE_ycbcr_422");
        this.GL_ARB_ES2_compatibility = supported_extensions.contains("GL_ARB_ES2_compatibility");
        this.GL_ARB_ES3_1_compatibility = supported_extensions.contains("GL_ARB_ES3_1_compatibility");
        this.GL_ARB_ES3_compatibility = supported_extensions.contains("GL_ARB_ES3_compatibility");
        this.GL_ARB_arrays_of_arrays = supported_extensions.contains("GL_ARB_arrays_of_arrays");
        this.GL_ARB_base_instance = supported_extensions.contains("GL_ARB_base_instance");
        this.GL_ARB_bindless_texture = supported_extensions.contains("GL_ARB_bindless_texture");
        this.GL_ARB_blend_func_extended = supported_extensions.contains("GL_ARB_blend_func_extended");
        this.GL_ARB_buffer_storage = supported_extensions.contains("GL_ARB_buffer_storage");
        this.GL_ARB_cl_event = supported_extensions.contains("GL_ARB_cl_event");
        this.GL_ARB_clear_buffer_object = supported_extensions.contains("GL_ARB_clear_buffer_object");
        this.GL_ARB_clear_texture = supported_extensions.contains("GL_ARB_clear_texture");
        this.GL_ARB_clip_control = supported_extensions.contains("GL_ARB_clip_control");
        this.GL_ARB_color_buffer_float = supported_extensions.contains("GL_ARB_color_buffer_float");
        this.GL_ARB_compatibility = supported_extensions.contains("GL_ARB_compatibility");
        this.GL_ARB_compressed_texture_pixel_storage = supported_extensions.contains("GL_ARB_compressed_texture_pixel_storage");
        this.GL_ARB_compute_shader = supported_extensions.contains("GL_ARB_compute_shader");
        this.GL_ARB_compute_variable_group_size = supported_extensions.contains("GL_ARB_compute_variable_group_size");
        this.GL_ARB_conditional_render_inverted = supported_extensions.contains("GL_ARB_conditional_render_inverted");
        this.GL_ARB_conservative_depth = supported_extensions.contains("GL_ARB_conservative_depth");
        this.GL_ARB_copy_buffer = supported_extensions.contains("GL_ARB_copy_buffer");
        this.GL_ARB_copy_image = supported_extensions.contains("GL_ARB_copy_image");
        this.GL_ARB_cull_distance = supported_extensions.contains("GL_ARB_cull_distance");
        this.GL_ARB_debug_output = supported_extensions.contains("GL_ARB_debug_output");
        this.GL_ARB_depth_buffer_float = supported_extensions.contains("GL_ARB_depth_buffer_float");
        this.GL_ARB_depth_clamp = supported_extensions.contains("GL_ARB_depth_clamp");
        this.GL_ARB_depth_texture = supported_extensions.contains("GL_ARB_depth_texture");
        this.GL_ARB_derivative_control = supported_extensions.contains("GL_ARB_derivative_control");
        this.GL_ARB_direct_state_access = supported_extensions.contains("GL_ARB_direct_state_access");
        this.GL_ARB_draw_buffers = supported_extensions.contains("GL_ARB_draw_buffers");
        this.GL_ARB_draw_buffers_blend = supported_extensions.contains("GL_ARB_draw_buffers_blend");
        this.GL_ARB_draw_elements_base_vertex = supported_extensions.contains("GL_ARB_draw_elements_base_vertex");
        this.GL_ARB_draw_indirect = supported_extensions.contains("GL_ARB_draw_indirect");
        this.GL_ARB_draw_instanced = supported_extensions.contains("GL_ARB_draw_instanced");
        this.GL_ARB_enhanced_layouts = supported_extensions.contains("GL_ARB_enhanced_layouts");
        this.GL_ARB_explicit_attrib_location = supported_extensions.contains("GL_ARB_explicit_attrib_location");
        this.GL_ARB_explicit_uniform_location = supported_extensions.contains("GL_ARB_explicit_uniform_location");
        this.GL_ARB_fragment_coord_conventions = supported_extensions.contains("GL_ARB_fragment_coord_conventions");
        this.GL_ARB_fragment_layer_viewport = supported_extensions.contains("GL_ARB_fragment_layer_viewport");
        this.GL_ARB_fragment_program = supported_extensions.contains("GL_ARB_fragment_program") && supported_extensions.contains("GL_ARB_program");
        this.GL_ARB_fragment_program_shadow = supported_extensions.contains("GL_ARB_fragment_program_shadow");
        this.GL_ARB_fragment_shader = supported_extensions.contains("GL_ARB_fragment_shader");
        this.GL_ARB_framebuffer_no_attachments = supported_extensions.contains("GL_ARB_framebuffer_no_attachments");
        this.GL_ARB_framebuffer_object = supported_extensions.contains("GL_ARB_framebuffer_object");
        this.GL_ARB_framebuffer_sRGB = supported_extensions.contains("GL_ARB_framebuffer_sRGB");
        this.GL_ARB_geometry_shader4 = supported_extensions.contains("GL_ARB_geometry_shader4");
        this.GL_ARB_get_program_binary = supported_extensions.contains("GL_ARB_get_program_binary");
        this.GL_ARB_get_texture_sub_image = supported_extensions.contains("GL_ARB_get_texture_sub_image");
        this.GL_ARB_gpu_shader5 = supported_extensions.contains("GL_ARB_gpu_shader5");
        this.GL_ARB_gpu_shader_fp64 = supported_extensions.contains("GL_ARB_gpu_shader_fp64");
        this.GL_ARB_half_float_pixel = supported_extensions.contains("GL_ARB_half_float_pixel");
        this.GL_ARB_half_float_vertex = supported_extensions.contains("GL_ARB_half_float_vertex");
        this.GL_ARB_imaging = supported_extensions.contains("GL_ARB_imaging");
        this.GL_ARB_indirect_parameters = supported_extensions.contains("GL_ARB_indirect_parameters");
        this.GL_ARB_instanced_arrays = supported_extensions.contains("GL_ARB_instanced_arrays");
        this.GL_ARB_internalformat_query = supported_extensions.contains("GL_ARB_internalformat_query");
        this.GL_ARB_internalformat_query2 = supported_extensions.contains("GL_ARB_internalformat_query2");
        this.GL_ARB_invalidate_subdata = supported_extensions.contains("GL_ARB_invalidate_subdata");
        this.GL_ARB_map_buffer_alignment = supported_extensions.contains("GL_ARB_map_buffer_alignment");
        this.GL_ARB_map_buffer_range = supported_extensions.contains("GL_ARB_map_buffer_range");
        this.GL_ARB_matrix_palette = supported_extensions.contains("GL_ARB_matrix_palette");
        this.GL_ARB_multi_bind = supported_extensions.contains("GL_ARB_multi_bind");
        this.GL_ARB_multi_draw_indirect = supported_extensions.contains("GL_ARB_multi_draw_indirect");
        this.GL_ARB_multisample = supported_extensions.contains("GL_ARB_multisample");
        this.GL_ARB_multitexture = supported_extensions.contains("GL_ARB_multitexture");
        this.GL_ARB_occlusion_query = supported_extensions.contains("GL_ARB_occlusion_query");
        this.GL_ARB_occlusion_query2 = supported_extensions.contains("GL_ARB_occlusion_query2");
        this.GL_ARB_pipeline_statistics_query = supported_extensions.contains("GL_ARB_pipeline_statistics_query");
        this.GL_ARB_pixel_buffer_object = supported_extensions.contains("GL_ARB_pixel_buffer_object") && supported_extensions.contains("GL_ARB_buffer_object");
        this.GL_ARB_point_parameters = supported_extensions.contains("GL_ARB_point_parameters");
        this.GL_ARB_point_sprite = supported_extensions.contains("GL_ARB_point_sprite");
        this.GL_ARB_program_interface_query = supported_extensions.contains("GL_ARB_program_interface_query");
        this.GL_ARB_provoking_vertex = supported_extensions.contains("GL_ARB_provoking_vertex");
        this.GL_ARB_query_buffer_object = supported_extensions.contains("GL_ARB_query_buffer_object");
        this.GL_ARB_robust_buffer_access_behavior = supported_extensions.contains("GL_ARB_robust_buffer_access_behavior");
        this.GL_ARB_robustness = supported_extensions.contains("GL_ARB_robustness");
        this.GL_ARB_robustness_isolation = supported_extensions.contains("GL_ARB_robustness_isolation");
        this.GL_ARB_sample_shading = supported_extensions.contains("GL_ARB_sample_shading");
        this.GL_ARB_sampler_objects = supported_extensions.contains("GL_ARB_sampler_objects");
        this.GL_ARB_seamless_cube_map = supported_extensions.contains("GL_ARB_seamless_cube_map");
        this.GL_ARB_seamless_cubemap_per_texture = supported_extensions.contains("GL_ARB_seamless_cubemap_per_texture");
        this.GL_ARB_separate_shader_objects = supported_extensions.contains("GL_ARB_separate_shader_objects");
        this.GL_ARB_shader_atomic_counters = supported_extensions.contains("GL_ARB_shader_atomic_counters");
        this.GL_ARB_shader_bit_encoding = supported_extensions.contains("GL_ARB_shader_bit_encoding");
        this.GL_ARB_shader_draw_parameters = supported_extensions.contains("GL_ARB_shader_draw_parameters");
        this.GL_ARB_shader_group_vote = supported_extensions.contains("GL_ARB_shader_group_vote");
        this.GL_ARB_shader_image_load_store = supported_extensions.contains("GL_ARB_shader_image_load_store");
        this.GL_ARB_shader_image_size = supported_extensions.contains("GL_ARB_shader_image_size");
        this.GL_ARB_shader_objects = supported_extensions.contains("GL_ARB_shader_objects");
        this.GL_ARB_shader_precision = supported_extensions.contains("GL_ARB_shader_precision");
        this.GL_ARB_shader_stencil_export = supported_extensions.contains("GL_ARB_shader_stencil_export");
        this.GL_ARB_shader_storage_buffer_object = supported_extensions.contains("GL_ARB_shader_storage_buffer_object");
        this.GL_ARB_shader_subroutine = supported_extensions.contains("GL_ARB_shader_subroutine");
        this.GL_ARB_shader_texture_image_samples = supported_extensions.contains("GL_ARB_shader_texture_image_samples");
        this.GL_ARB_shader_texture_lod = supported_extensions.contains("GL_ARB_shader_texture_lod");
        this.GL_ARB_shading_language_100 = supported_extensions.contains("GL_ARB_shading_language_100");
        this.GL_ARB_shading_language_420pack = supported_extensions.contains("GL_ARB_shading_language_420pack");
        this.GL_ARB_shading_language_include = supported_extensions.contains("GL_ARB_shading_language_include");
        this.GL_ARB_shading_language_packing = supported_extensions.contains("GL_ARB_shading_language_packing");
        this.GL_ARB_shadow = supported_extensions.contains("GL_ARB_shadow");
        this.GL_ARB_shadow_ambient = supported_extensions.contains("GL_ARB_shadow_ambient");
        this.GL_ARB_sparse_buffer = supported_extensions.contains("GL_ARB_sparse_buffer");
        this.GL_ARB_sparse_texture = supported_extensions.contains("GL_ARB_sparse_texture");
        this.GL_ARB_stencil_texturing = supported_extensions.contains("GL_ARB_stencil_texturing");
        this.GL_ARB_sync = supported_extensions.contains("GL_ARB_sync");
        this.GL_ARB_tessellation_shader = supported_extensions.contains("GL_ARB_tessellation_shader");
        this.GL_ARB_texture_barrier = supported_extensions.contains("GL_ARB_texture_barrier");
        this.GL_ARB_texture_border_clamp = supported_extensions.contains("GL_ARB_texture_border_clamp");
        this.GL_ARB_texture_buffer_object = supported_extensions.contains("GL_ARB_texture_buffer_object");
        this.GL_ARB_texture_buffer_object_rgb32 = supported_extensions.contains("GL_ARB_texture_buffer_object_rgb32") || supported_extensions.contains("GL_EXT_texture_buffer_object_rgb32");
        this.GL_ARB_texture_buffer_range = supported_extensions.contains("GL_ARB_texture_buffer_range");
        this.GL_ARB_texture_compression = supported_extensions.contains("GL_ARB_texture_compression");
        this.GL_ARB_texture_compression_bptc = supported_extensions.contains("GL_ARB_texture_compression_bptc") || supported_extensions.contains("GL_EXT_texture_compression_bptc");
        this.GL_ARB_texture_compression_rgtc = supported_extensions.contains("GL_ARB_texture_compression_rgtc");
        this.GL_ARB_texture_cube_map = supported_extensions.contains("GL_ARB_texture_cube_map");
        this.GL_ARB_texture_cube_map_array = supported_extensions.contains("GL_ARB_texture_cube_map_array");
        this.GL_ARB_texture_env_add = supported_extensions.contains("GL_ARB_texture_env_add");
        this.GL_ARB_texture_env_combine = supported_extensions.contains("GL_ARB_texture_env_combine");
        this.GL_ARB_texture_env_crossbar = supported_extensions.contains("GL_ARB_texture_env_crossbar");
        this.GL_ARB_texture_env_dot3 = supported_extensions.contains("GL_ARB_texture_env_dot3");
        this.GL_ARB_texture_float = supported_extensions.contains("GL_ARB_texture_float");
        this.GL_ARB_texture_gather = supported_extensions.contains("GL_ARB_texture_gather");
        this.GL_ARB_texture_mirror_clamp_to_edge = supported_extensions.contains("GL_ARB_texture_mirror_clamp_to_edge");
        this.GL_ARB_texture_mirrored_repeat = supported_extensions.contains("GL_ARB_texture_mirrored_repeat");
        this.GL_ARB_texture_multisample = supported_extensions.contains("GL_ARB_texture_multisample");
        this.GL_ARB_texture_non_power_of_two = supported_extensions.contains("GL_ARB_texture_non_power_of_two");
        this.GL_ARB_texture_query_levels = supported_extensions.contains("GL_ARB_texture_query_levels");
        this.GL_ARB_texture_query_lod = supported_extensions.contains("GL_ARB_texture_query_lod");
        this.GL_ARB_texture_rectangle = supported_extensions.contains("GL_ARB_texture_rectangle");
        this.GL_ARB_texture_rg = supported_extensions.contains("GL_ARB_texture_rg");
        this.GL_ARB_texture_rgb10_a2ui = supported_extensions.contains("GL_ARB_texture_rgb10_a2ui");
        this.GL_ARB_texture_stencil8 = supported_extensions.contains("GL_ARB_texture_stencil8");
        this.GL_ARB_texture_storage = supported_extensions.contains("GL_ARB_texture_storage") || supported_extensions.contains("GL_EXT_texture_storage");
        this.GL_ARB_texture_storage_multisample = supported_extensions.contains("GL_ARB_texture_storage_multisample");
        this.GL_ARB_texture_swizzle = supported_extensions.contains("GL_ARB_texture_swizzle");
        this.GL_ARB_texture_view = supported_extensions.contains("GL_ARB_texture_view");
        this.GL_ARB_timer_query = supported_extensions.contains("GL_ARB_timer_query");
        this.GL_ARB_transform_feedback2 = supported_extensions.contains("GL_ARB_transform_feedback2");
        this.GL_ARB_transform_feedback3 = supported_extensions.contains("GL_ARB_transform_feedback3");
        this.GL_ARB_transform_feedback_instanced = supported_extensions.contains("GL_ARB_transform_feedback_instanced");
        this.GL_ARB_transform_feedback_overflow_query = supported_extensions.contains("GL_ARB_transform_feedback_overflow_query");
        this.GL_ARB_transpose_matrix = supported_extensions.contains("GL_ARB_transpose_matrix");
        this.GL_ARB_uniform_buffer_object = supported_extensions.contains("GL_ARB_uniform_buffer_object");
        this.GL_ARB_vertex_array_bgra = supported_extensions.contains("GL_ARB_vertex_array_bgra");
        this.GL_ARB_vertex_array_object = supported_extensions.contains("GL_ARB_vertex_array_object");
        this.GL_ARB_vertex_attrib_64bit = supported_extensions.contains("GL_ARB_vertex_attrib_64bit");
        this.GL_ARB_vertex_attrib_binding = supported_extensions.contains("GL_ARB_vertex_attrib_binding");
        this.GL_ARB_vertex_blend = supported_extensions.contains("GL_ARB_vertex_blend");
        this.GL_ARB_vertex_buffer_object = supported_extensions.contains("GL_ARB_vertex_buffer_object") && supported_extensions.contains("GL_ARB_buffer_object");
        this.GL_ARB_vertex_program = supported_extensions.contains("GL_ARB_vertex_program") && supported_extensions.contains("GL_ARB_program");
        this.GL_ARB_vertex_shader = supported_extensions.contains("GL_ARB_vertex_shader");
        this.GL_ARB_vertex_type_10f_11f_11f_rev = supported_extensions.contains("GL_ARB_vertex_type_10f_11f_11f_rev");
        this.GL_ARB_vertex_type_2_10_10_10_rev = supported_extensions.contains("GL_ARB_vertex_type_2_10_10_10_rev");
        this.GL_ARB_viewport_array = supported_extensions.contains("GL_ARB_viewport_array");
        this.GL_ARB_window_pos = supported_extensions.contains("GL_ARB_window_pos");
        this.GL_ATI_draw_buffers = supported_extensions.contains("GL_ATI_draw_buffers");
        this.GL_ATI_element_array = supported_extensions.contains("GL_ATI_element_array");
        this.GL_ATI_envmap_bumpmap = supported_extensions.contains("GL_ATI_envmap_bumpmap");
        this.GL_ATI_fragment_shader = supported_extensions.contains("GL_ATI_fragment_shader");
        this.GL_ATI_map_object_buffer = supported_extensions.contains("GL_ATI_map_object_buffer");
        this.GL_ATI_meminfo = supported_extensions.contains("GL_ATI_meminfo");
        this.GL_ATI_pn_triangles = supported_extensions.contains("GL_ATI_pn_triangles");
        this.GL_ATI_separate_stencil = supported_extensions.contains("GL_ATI_separate_stencil");
        this.GL_ATI_shader_texture_lod = supported_extensions.contains("GL_ATI_shader_texture_lod");
        this.GL_ATI_text_fragment_shader = supported_extensions.contains("GL_ATI_text_fragment_shader");
        this.GL_ATI_texture_compression_3dc = supported_extensions.contains("GL_ATI_texture_compression_3dc");
        this.GL_ATI_texture_env_combine3 = supported_extensions.contains("GL_ATI_texture_env_combine3");
        this.GL_ATI_texture_float = supported_extensions.contains("GL_ATI_texture_float");
        this.GL_ATI_texture_mirror_once = supported_extensions.contains("GL_ATI_texture_mirror_once");
        this.GL_ATI_vertex_array_object = supported_extensions.contains("GL_ATI_vertex_array_object");
        this.GL_ATI_vertex_attrib_array_object = supported_extensions.contains("GL_ATI_vertex_attrib_array_object");
        this.GL_ATI_vertex_streams = supported_extensions.contains("GL_ATI_vertex_streams");
        this.GL_EXT_Cg_shader = supported_extensions.contains("GL_EXT_Cg_shader");
        this.GL_EXT_abgr = supported_extensions.contains("GL_EXT_abgr");
        this.GL_EXT_bgra = supported_extensions.contains("GL_EXT_bgra");
        this.GL_EXT_bindable_uniform = supported_extensions.contains("GL_EXT_bindable_uniform");
        this.GL_EXT_blend_color = supported_extensions.contains("GL_EXT_blend_color");
        this.GL_EXT_blend_equation_separate = supported_extensions.contains("GL_EXT_blend_equation_separate");
        this.GL_EXT_blend_func_separate = supported_extensions.contains("GL_EXT_blend_func_separate");
        this.GL_EXT_blend_minmax = supported_extensions.contains("GL_EXT_blend_minmax");
        this.GL_EXT_blend_subtract = supported_extensions.contains("GL_EXT_blend_subtract");
        this.GL_EXT_compiled_vertex_array = supported_extensions.contains("GL_EXT_compiled_vertex_array");
        this.GL_EXT_depth_bounds_test = supported_extensions.contains("GL_EXT_depth_bounds_test");
        this.GL_EXT_direct_state_access = supported_extensions.contains("GL_EXT_direct_state_access");
        this.GL_EXT_draw_buffers2 = supported_extensions.contains("GL_EXT_draw_buffers2");
        this.GL_EXT_draw_instanced = supported_extensions.contains("GL_EXT_draw_instanced");
        this.GL_EXT_draw_range_elements = supported_extensions.contains("GL_EXT_draw_range_elements");
        this.GL_EXT_fog_coord = supported_extensions.contains("GL_EXT_fog_coord");
        this.GL_EXT_framebuffer_blit = supported_extensions.contains("GL_EXT_framebuffer_blit");
        this.GL_EXT_framebuffer_multisample = supported_extensions.contains("GL_EXT_framebuffer_multisample");
        this.GL_EXT_framebuffer_multisample_blit_scaled = supported_extensions.contains("GL_EXT_framebuffer_multisample_blit_scaled");
        this.GL_EXT_framebuffer_object = supported_extensions.contains("GL_EXT_framebuffer_object");
        this.GL_EXT_framebuffer_sRGB = supported_extensions.contains("GL_EXT_framebuffer_sRGB");
        this.GL_EXT_geometry_shader4 = supported_extensions.contains("GL_EXT_geometry_shader4");
        this.GL_EXT_gpu_program_parameters = supported_extensions.contains("GL_EXT_gpu_program_parameters");
        this.GL_EXT_gpu_shader4 = supported_extensions.contains("GL_EXT_gpu_shader4");
        this.GL_EXT_multi_draw_arrays = supported_extensions.contains("GL_EXT_multi_draw_arrays");
        this.GL_EXT_packed_depth_stencil = supported_extensions.contains("GL_EXT_packed_depth_stencil");
        this.GL_EXT_packed_float = supported_extensions.contains("GL_EXT_packed_float");
        this.GL_EXT_packed_pixels = supported_extensions.contains("GL_EXT_packed_pixels");
        this.GL_EXT_paletted_texture = supported_extensions.contains("GL_EXT_paletted_texture");
        this.GL_EXT_pixel_buffer_object = supported_extensions.contains("GL_EXT_pixel_buffer_object") && supported_extensions.contains("GL_ARB_buffer_object");
        this.GL_EXT_point_parameters = supported_extensions.contains("GL_EXT_point_parameters");
        this.GL_EXT_provoking_vertex = supported_extensions.contains("GL_EXT_provoking_vertex");
        this.GL_EXT_rescale_normal = supported_extensions.contains("GL_EXT_rescale_normal");
        this.GL_EXT_secondary_color = supported_extensions.contains("GL_EXT_secondary_color");
        this.GL_EXT_separate_shader_objects = supported_extensions.contains("GL_EXT_separate_shader_objects");
        this.GL_EXT_separate_specular_color = supported_extensions.contains("GL_EXT_separate_specular_color");
        this.GL_EXT_shader_image_load_store = supported_extensions.contains("GL_EXT_shader_image_load_store");
        this.GL_EXT_shadow_funcs = supported_extensions.contains("GL_EXT_shadow_funcs");
        this.GL_EXT_shared_texture_palette = supported_extensions.contains("GL_EXT_shared_texture_palette");
        this.GL_EXT_stencil_clear_tag = supported_extensions.contains("GL_EXT_stencil_clear_tag");
        this.GL_EXT_stencil_two_side = supported_extensions.contains("GL_EXT_stencil_two_side");
        this.GL_EXT_stencil_wrap = supported_extensions.contains("GL_EXT_stencil_wrap");
        this.GL_EXT_texture_3d = supported_extensions.contains("GL_EXT_texture_3d");
        this.GL_EXT_texture_array = supported_extensions.contains("GL_EXT_texture_array");
        this.GL_EXT_texture_buffer_object = supported_extensions.contains("GL_EXT_texture_buffer_object");
        this.GL_EXT_texture_compression_latc = supported_extensions.contains("GL_EXT_texture_compression_latc");
        this.GL_EXT_texture_compression_rgtc = supported_extensions.contains("GL_EXT_texture_compression_rgtc");
        this.GL_EXT_texture_compression_s3tc = supported_extensions.contains("GL_EXT_texture_compression_s3tc");
        this.GL_EXT_texture_env_combine = supported_extensions.contains("GL_EXT_texture_env_combine");
        this.GL_EXT_texture_env_dot3 = supported_extensions.contains("GL_EXT_texture_env_dot3");
        this.GL_EXT_texture_filter_anisotropic = supported_extensions.contains("GL_EXT_texture_filter_anisotropic");
        this.GL_EXT_texture_integer = supported_extensions.contains("GL_EXT_texture_integer");
        this.GL_EXT_texture_lod_bias = supported_extensions.contains("GL_EXT_texture_lod_bias");
        this.GL_EXT_texture_mirror_clamp = supported_extensions.contains("GL_EXT_texture_mirror_clamp");
        this.GL_EXT_texture_rectangle = supported_extensions.contains("GL_EXT_texture_rectangle");
        this.GL_EXT_texture_sRGB = supported_extensions.contains("GL_EXT_texture_sRGB");
        this.GL_EXT_texture_sRGB_decode = supported_extensions.contains("GL_EXT_texture_sRGB_decode");
        this.GL_EXT_texture_shared_exponent = supported_extensions.contains("GL_EXT_texture_shared_exponent");
        this.GL_EXT_texture_snorm = supported_extensions.contains("GL_EXT_texture_snorm");
        this.GL_EXT_texture_swizzle = supported_extensions.contains("GL_EXT_texture_swizzle");
        this.GL_EXT_timer_query = supported_extensions.contains("GL_EXT_timer_query");
        this.GL_EXT_transform_feedback = supported_extensions.contains("GL_EXT_transform_feedback");
        this.GL_EXT_vertex_array_bgra = supported_extensions.contains("GL_EXT_vertex_array_bgra");
        this.GL_EXT_vertex_attrib_64bit = supported_extensions.contains("GL_EXT_vertex_attrib_64bit");
        this.GL_EXT_vertex_shader = supported_extensions.contains("GL_EXT_vertex_shader");
        this.GL_EXT_vertex_weighting = supported_extensions.contains("GL_EXT_vertex_weighting");
        this.OpenGL11 = supported_extensions.contains("OpenGL11");
        this.OpenGL12 = supported_extensions.contains("OpenGL12");
        this.OpenGL13 = supported_extensions.contains("OpenGL13");
        this.OpenGL14 = supported_extensions.contains("OpenGL14");
        this.OpenGL15 = supported_extensions.contains("OpenGL15");
        this.OpenGL20 = supported_extensions.contains("OpenGL20");
        this.OpenGL21 = supported_extensions.contains("OpenGL21");
        this.OpenGL30 = supported_extensions.contains("OpenGL30");
        this.OpenGL31 = supported_extensions.contains("OpenGL31");
        this.OpenGL32 = supported_extensions.contains("OpenGL32");
        this.OpenGL33 = supported_extensions.contains("OpenGL33");
        this.OpenGL40 = supported_extensions.contains("OpenGL40");
        this.OpenGL41 = supported_extensions.contains("OpenGL41");
        this.OpenGL42 = supported_extensions.contains("OpenGL42");
        this.OpenGL43 = supported_extensions.contains("OpenGL43");
        this.OpenGL44 = supported_extensions.contains("OpenGL44");
        this.OpenGL45 = supported_extensions.contains("OpenGL45");
        this.GL_GREMEDY_frame_terminator = supported_extensions.contains("GL_GREMEDY_frame_terminator");
        this.GL_GREMEDY_string_marker = supported_extensions.contains("GL_GREMEDY_string_marker");
        this.GL_HP_occlusion_test = supported_extensions.contains("GL_HP_occlusion_test");
        this.GL_IBM_rasterpos_clip = supported_extensions.contains("GL_IBM_rasterpos_clip");
        this.GL_INTEL_map_texture = supported_extensions.contains("GL_INTEL_map_texture");
        this.GL_KHR_context_flush_control = supported_extensions.contains("GL_KHR_context_flush_control");
        this.GL_KHR_debug = supported_extensions.contains("GL_KHR_debug");
        this.GL_KHR_robust_buffer_access_behavior = supported_extensions.contains("GL_KHR_robust_buffer_access_behavior");
        this.GL_KHR_robustness = supported_extensions.contains("GL_KHR_robustness");
        this.GL_KHR_texture_compression_astc_ldr = supported_extensions.contains("GL_KHR_texture_compression_astc_ldr");
        this.GL_NVX_gpu_memory_info = supported_extensions.contains("GL_NVX_gpu_memory_info");
        this.GL_NV_bindless_multi_draw_indirect = supported_extensions.contains("GL_NV_bindless_multi_draw_indirect");
        this.GL_NV_bindless_texture = supported_extensions.contains("GL_NV_bindless_texture");
        this.GL_NV_blend_equation_advanced = supported_extensions.contains("GL_NV_blend_equation_advanced");
        this.GL_NV_blend_square = supported_extensions.contains("GL_NV_blend_square");
        this.GL_NV_compute_program5 = supported_extensions.contains("GL_NV_compute_program5");
        this.GL_NV_conditional_render = supported_extensions.contains("GL_NV_conditional_render");
        this.GL_NV_copy_depth_to_color = supported_extensions.contains("GL_NV_copy_depth_to_color");
        this.GL_NV_copy_image = supported_extensions.contains("GL_NV_copy_image");
        this.GL_NV_deep_texture3D = supported_extensions.contains("GL_NV_deep_texture3D");
        this.GL_NV_depth_buffer_float = supported_extensions.contains("GL_NV_depth_buffer_float");
        this.GL_NV_depth_clamp = supported_extensions.contains("GL_NV_depth_clamp");
        this.GL_NV_draw_texture = supported_extensions.contains("GL_NV_draw_texture");
        this.GL_NV_evaluators = supported_extensions.contains("GL_NV_evaluators");
        this.GL_NV_explicit_multisample = supported_extensions.contains("GL_NV_explicit_multisample");
        this.GL_NV_fence = supported_extensions.contains("GL_NV_fence");
        this.GL_NV_float_buffer = supported_extensions.contains("GL_NV_float_buffer");
        this.GL_NV_fog_distance = supported_extensions.contains("GL_NV_fog_distance");
        this.GL_NV_fragment_program = supported_extensions.contains("GL_NV_fragment_program") && supported_extensions.contains("GL_NV_program");
        this.GL_NV_fragment_program2 = supported_extensions.contains("GL_NV_fragment_program2");
        this.GL_NV_fragment_program4 = supported_extensions.contains("GL_NV_fragment_program4");
        this.GL_NV_fragment_program_option = supported_extensions.contains("GL_NV_fragment_program_option");
        this.GL_NV_framebuffer_multisample_coverage = supported_extensions.contains("GL_NV_framebuffer_multisample_coverage");
        this.GL_NV_geometry_program4 = supported_extensions.contains("GL_NV_geometry_program4");
        this.GL_NV_geometry_shader4 = supported_extensions.contains("GL_NV_geometry_shader4");
        this.GL_NV_gpu_program4 = supported_extensions.contains("GL_NV_gpu_program4");
        this.GL_NV_gpu_program5 = supported_extensions.contains("GL_NV_gpu_program5");
        this.GL_NV_gpu_program5_mem_extended = supported_extensions.contains("GL_NV_gpu_program5_mem_extended");
        this.GL_NV_gpu_shader5 = supported_extensions.contains("GL_NV_gpu_shader5");
        this.GL_NV_half_float = supported_extensions.contains("GL_NV_half_float");
        this.GL_NV_light_max_exponent = supported_extensions.contains("GL_NV_light_max_exponent");
        this.GL_NV_multisample_coverage = supported_extensions.contains("GL_NV_multisample_coverage");
        this.GL_NV_multisample_filter_hint = supported_extensions.contains("GL_NV_multisample_filter_hint");
        this.GL_NV_occlusion_query = supported_extensions.contains("GL_NV_occlusion_query");
        this.GL_NV_packed_depth_stencil = supported_extensions.contains("GL_NV_packed_depth_stencil");
        this.GL_NV_parameter_buffer_object = supported_extensions.contains("GL_NV_parameter_buffer_object");
        this.GL_NV_parameter_buffer_object2 = supported_extensions.contains("GL_NV_parameter_buffer_object2");
        this.GL_NV_path_rendering = supported_extensions.contains("GL_NV_path_rendering");
        this.GL_NV_pixel_data_range = supported_extensions.contains("GL_NV_pixel_data_range");
        this.GL_NV_point_sprite = supported_extensions.contains("GL_NV_point_sprite");
        this.GL_NV_present_video = supported_extensions.contains("GL_NV_present_video");
        this.GL_NV_primitive_restart = supported_extensions.contains("GL_NV_primitive_restart");
        this.GL_NV_register_combiners = supported_extensions.contains("GL_NV_register_combiners");
        this.GL_NV_register_combiners2 = supported_extensions.contains("GL_NV_register_combiners2");
        this.GL_NV_shader_atomic_counters = supported_extensions.contains("GL_NV_shader_atomic_counters");
        this.GL_NV_shader_atomic_float = supported_extensions.contains("GL_NV_shader_atomic_float");
        this.GL_NV_shader_buffer_load = supported_extensions.contains("GL_NV_shader_buffer_load");
        this.GL_NV_shader_buffer_store = supported_extensions.contains("GL_NV_shader_buffer_store");
        this.GL_NV_shader_storage_buffer_object = supported_extensions.contains("GL_NV_shader_storage_buffer_object");
        this.GL_NV_tessellation_program5 = supported_extensions.contains("GL_NV_tessellation_program5");
        this.GL_NV_texgen_reflection = supported_extensions.contains("GL_NV_texgen_reflection");
        this.GL_NV_texture_barrier = supported_extensions.contains("GL_NV_texture_barrier");
        this.GL_NV_texture_compression_vtc = supported_extensions.contains("GL_NV_texture_compression_vtc");
        this.GL_NV_texture_env_combine4 = supported_extensions.contains("GL_NV_texture_env_combine4");
        this.GL_NV_texture_expand_normal = supported_extensions.contains("GL_NV_texture_expand_normal");
        this.GL_NV_texture_multisample = supported_extensions.contains("GL_NV_texture_multisample");
        this.GL_NV_texture_rectangle = supported_extensions.contains("GL_NV_texture_rectangle");
        this.GL_NV_texture_shader = supported_extensions.contains("GL_NV_texture_shader");
        this.GL_NV_texture_shader2 = supported_extensions.contains("GL_NV_texture_shader2");
        this.GL_NV_texture_shader3 = supported_extensions.contains("GL_NV_texture_shader3");
        this.GL_NV_transform_feedback = supported_extensions.contains("GL_NV_transform_feedback");
        this.GL_NV_transform_feedback2 = supported_extensions.contains("GL_NV_transform_feedback2");
        this.GL_NV_vertex_array_range = supported_extensions.contains("GL_NV_vertex_array_range");
        this.GL_NV_vertex_array_range2 = supported_extensions.contains("GL_NV_vertex_array_range2");
        this.GL_NV_vertex_attrib_integer_64bit = supported_extensions.contains("GL_NV_vertex_attrib_integer_64bit");
        this.GL_NV_vertex_buffer_unified_memory = supported_extensions.contains("GL_NV_vertex_buffer_unified_memory");
        this.GL_NV_vertex_program = supported_extensions.contains("GL_NV_vertex_program") && supported_extensions.contains("GL_NV_program");
        this.GL_NV_vertex_program1_1 = supported_extensions.contains("GL_NV_vertex_program1_1");
        this.GL_NV_vertex_program2 = supported_extensions.contains("GL_NV_vertex_program2");
        this.GL_NV_vertex_program2_option = supported_extensions.contains("GL_NV_vertex_program2_option");
        this.GL_NV_vertex_program3 = supported_extensions.contains("GL_NV_vertex_program3");
        this.GL_NV_vertex_program4 = supported_extensions.contains("GL_NV_vertex_program4");
        this.GL_NV_video_capture = supported_extensions.contains("GL_NV_video_capture");
        this.GL_SGIS_generate_mipmap = supported_extensions.contains("GL_SGIS_generate_mipmap");
        this.GL_SGIS_texture_lod = supported_extensions.contains("GL_SGIS_texture_lod");
        this.GL_SUN_slice_accum = supported_extensions.contains("GL_SUN_slice_accum");
        this.tracker.init();
    }
}
