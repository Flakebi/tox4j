// Instance manager, JNI utilities.
#include "tox4j/Tox4j.h"

// Protobuf classes.
#include "Av.pb.h"

// JNI declarations from javah.
#include "im_tox_tox4j_ToxAvImpl.h"

// Header from toxcore.
#include <tox/av.h>

#define SUBSYSTEM TOXV
#define CLASS     ToxAv
#define PREFIX    toxav

namespace av
{
  namespace proto = im::tox::tox4j::av::proto;

  using Events = proto::AvEvents;

  extern ToxInstances<tox::av_ptr, Events> instances;
}
